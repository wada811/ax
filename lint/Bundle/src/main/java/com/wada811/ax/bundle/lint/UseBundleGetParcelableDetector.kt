package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

@Suppress("UnstableApiUsage")
class UseBundleGetParcelableDetector : Detector(), SourceCodeScanner {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetParcelable",
            briefDescription = "Use newer getParcelable or deprecated getParcelable",
            explanation = "Use `getParcelableOrNull` or getParcelableOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetParcelableDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }

    override fun getApplicableMethodNames(): List<String> = listOf(
        "getParcelable",
    )

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if (!context.evaluator.isMemberInClass(method, "android.os.Bundle")) {
            return
        }
        context.report(
            Incident(
                issue = ISSUE,
                scope = node,
                location = context.getLocation(node),
                message = "Use getParcelableOrNull or getParcelableOrThrow",
                fix = quickFix(node)
            )
        )
    }

    private fun quickFix(node: UCallExpression): LintFix {
        return fix()
            .group()
            .add(node.toLintFix("getParcelable", "getParcelableOrThrow"))
            .add(node.toLintFix("getParcelable", "getParcelableOrNull"))
            .build()
    }

    private fun UCallExpression.toLintFix(oldMethodName: String, newMethodName: String): LintFix {
        val callSource = requireNotNull(sourcePsi?.text)
        val newerMethodRegex = Regex("$oldMethodName\\((.*), (\\w+).*\\)")
        val deprecatedMethodRegex = Regex("$oldMethodName<(.*)>\\((.*)\\)")
        val omitTypeArgumentsMethodRegex = Regex("$oldMethodName\\((.*)\\)")
        val newSource = when {
            newerMethodRegex.matches(callSource) -> newerMethodRegex.replace(callSource, "$newMethodName<$2>($1)")
            deprecatedMethodRegex.matches(callSource) -> deprecatedMethodRegex.replace(callSource, "$newMethodName<$1>($2)")
            omitTypeArgumentsMethodRegex.matches(callSource) -> omitTypeArgumentsMethodRegex.replace(callSource, "$newMethodName($1)")
            else -> callSource
        }
        return fix()
            .replace()
            .text(callSource)
            .shortenNames()
            .reformat(true)
            .with(newSource)
            .build()
    }
}
