package com.wada811.adx.context.lint

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression
import org.jetbrains.uast.UElement

@Suppress("UnstableApiUsage")
class UseContextGetSystemServiceDetector : Detector(), SourceCodeScanner {
    companion object {
        val ISSUE = Issue.create(
            id = "UseUnsafeNullableGetSystemService",
            briefDescription = "Use nullable getSystemService(name) or getSystemService(serviceClass)",
            explanation = "Use getSystemService<T>() or requireSystemService<T>()",
            category = Category.CORRECTNESS,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseContextGetSystemServiceDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }

    override fun getApplicableMethodNames(): List<String> = listOf(
        "getSystemService",
    )

    private val olderMethodRegex = Regex("(\\w+)\\.getSystemService\\(.*\\) as (\\w+)")
    private val newerMethodRegex = Regex("(\\w+)\\.getSystemService\\((\\w+).*\\)")

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if (!context.evaluator.isMemberInClass(method, "android.content.Context")) {
            return
        }
        if (method.hasParameters()) {
            if (node.isOlderMethod()) {
                context.report(
                    context.incident(node, node.maybeOlderMethodElement())
                )
            } else if (node.isNewerMethod()) {
                context.report(
                    context.incident(node, node.maybeNewerMethodElement())
                )
            }
        }
    }

    private fun UCallExpression.maybeOlderMethodElement(): UElement? = uastParent?.uastParent
    private fun UCallExpression.maybeNewerMethodElement(): UElement? = uastParent
    private fun UCallExpression.maybeOlderMethodSource(): String = maybeOlderMethodElement()?.sourcePsi?.text ?: ""
    private fun UCallExpression.maybeNewerMethodSource(): String = maybeNewerMethodElement()?.sourcePsi?.text ?: ""

    private fun UCallExpression.isOlderMethod(): Boolean {
        return olderMethodRegex.matches(maybeOlderMethodSource())
    }

    private fun UCallExpression.isNewerMethod(): Boolean {
        return newerMethodRegex.matches(maybeNewerMethodSource())
    }

    private fun JavaContext.incident(node: UCallExpression, element: UElement?): Incident {
        return Incident(
            issue = ISSUE,
            scope = element,
            location = getLocation(element),
            message = "Use getSystemService<T>() or requireSystemService<T>()",
            fix = quickFix(node)
        )
    }

    private fun quickFix(node: UCallExpression): LintFix {
        return fix()
            .group()
            .add(node.toLintFix("requireSystemService"))
            .add(node.toLintFix("getSystemService"))
            .build()
    }

    private fun UCallExpression.toLintFix(newMethodName: String): LintFix {
        val (source, newSource) = when {
            isOlderMethod() -> maybeOlderMethodSource() to olderMethodRegex.replace(maybeOlderMethodSource(), "$1\\.$newMethodName<$2>()")
            isNewerMethod() -> maybeNewerMethodSource() to newerMethodRegex.replace(maybeNewerMethodSource(), "$1\\.$newMethodName<$2>()")
            else -> throw IllegalStateException("Source is not matched: ${maybeOlderMethodSource()}")
        }
        return fix()
            .replace()
            .text(source)
            .shortenNames()
            .reformat(true)
            .with(newSource)
            .build()
    }
}
