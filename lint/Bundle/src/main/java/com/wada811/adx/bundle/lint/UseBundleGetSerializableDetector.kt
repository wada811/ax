package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

@Suppress("UnstableApiUsage")
class UseBundleGetSerializableDetector : Detector(), SourceCodeScanner {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetSerializable",
            briefDescription = "Use newer getSerializable or deprecated getSerializable",
            explanation = "Use `getSerializableOrNull` or getSerializableOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetSerializableDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }

    override fun getApplicableMethodNames(): List<String> = listOf(
        "getSerializable",
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
                message = "Use getSerializableOrNull or getSerializableOrThrow",
                fix = quickFix(node)
            )
        )
    }

    private fun quickFix(node: UCallExpression): LintFix {
        return fix()
            .group()
            .add(node.toLintFix("getSerializable", "getSerializableOrThrow"))
            .add(node.toLintFix("getSerializable", "getSerializableOrNull"))
            .build()
    }

    private fun UCallExpression.toLintFix(oldMethodName: String, newMethodName: String): LintFix {
        val callSource = requireNotNull(sourcePsi?.text)
        val newerMethodRegex = Regex("$oldMethodName\\((.*), (\\w+).*\\)")
        val deprecatedMethodRegex = Regex("$oldMethodName\\((.*)\\)")
        val newSource = when {
            newerMethodRegex.matches(callSource) -> newerMethodRegex.replace(callSource, "$newMethodName<$2>($1)")
            deprecatedMethodRegex.matches(callSource) -> deprecatedMethodRegex.replace(callSource, "$newMethodName($1)")
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
