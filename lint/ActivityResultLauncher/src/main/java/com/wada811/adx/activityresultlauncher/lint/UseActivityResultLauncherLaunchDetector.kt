package com.wada811.adx.activityresultlauncher.lint

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

@Suppress("UnstableApiUsage")
class UseActivityResultLauncherLaunchDetector : Detector(), SourceCodeScanner {
    companion object {
        val ISSUE = Issue.create(
            id = "UseActivityResultLauncherLaunch",
            briefDescription = "Use unsafe ActivityResultLauncher#launch",
            explanation = "Use `ActivityResultLauncher`#launchCatching",
            category = Category.CORRECTNESS,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseActivityResultLauncherLaunchDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }

    override fun getApplicableMethodNames(): List<String> = listOf(
        "launch",
    )

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if (!context.evaluator.isMemberInClass(method, "androidx.activity.result.ActivityResultLauncher")) {
            return
        }
        context.report(
            Incident(
                issue = ISSUE,
                scope = node,
                location = context.getLocation(node),
                message = "Use ActivityResultLauncher#launchCatching",
                fix = quickFix(node)
            )
        )
    }

    private fun quickFix(node: UCallExpression): LintFix {
        return fix()
            .group()
            .add(node.toLintFix("launch", "launchCatching"))
            .build()
    }

    private fun UCallExpression.toLintFix(oldMethodName: String, newMethodName: String): LintFix {
        val callSource = requireNotNull(sourcePsi?.text)
        return fix()
            .replace()
            .text(callSource)
            .with(callSource.replace(Regex("$oldMethodName\\((.*)\\)"), "$newMethodName($1)"))
            .imports("com.wada811.adx.androidx.launchCatching")
            .shortenNames()
            .reformat(true)
            .autoFix()
            .build()
    }
}
