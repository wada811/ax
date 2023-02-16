package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Incident
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.LintFix
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.android.tools.lint.detector.api.SourceCodeScanner
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

@Suppress("UnstableApiUsage")
class UseIntentGetParcelableArrayListExtraDetector : Detector(), SourceCodeScanner {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetParcelableArrayListExtra",
            briefDescription = "Use newer getParcelableArrayListExtra or deprecated getParcelableArrayListExtra",
            explanation = "Use `getParcelableArrayListExtraOrNull` or requireParcelableArrayListExtra",
            category = Category.CORRECTNESS,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetParcelableArrayListExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }

    override fun getApplicableMethodNames(): List<String> = listOf(
        "getParcelableArrayListExtra",
    )

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if (!context.evaluator.isMemberInClass(method, "android.content.Intent")) {
            return
        }
        context.report(
            Incident(
                issue = ISSUE,
                scope = node,
                location = context.getLocation(node),
                message = "Use getParcelableArrayListExtraOrNull or requireParcelableArrayListExtra",
                fix = quickFix(node)
            )
        )
    }

    private fun quickFix(node: UCallExpression): LintFix {
        return fix()
            .group()
            .add(node.toLintFix("getParcelableArrayListExtra", "requireParcelableArrayListExtra"))
            .add(node.toLintFix("getParcelableArrayListExtra", "getParcelableArrayListExtraOrNull"))
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
