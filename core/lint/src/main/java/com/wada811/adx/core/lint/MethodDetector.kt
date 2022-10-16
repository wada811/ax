package com.wada811.adx.core.lint

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

@Suppress("UnstableApiUsage")
abstract class MethodDetector(
    private val issue: Issue,
    private val className: String,
    private val applicableMethodNames: List<String>,
    private val replacementMethodNames: List<String>,
    private val imports: List<String> = emptyList()
) : Detector(), SourceCodeScanner {
    override fun getApplicableMethodNames(): List<String> = applicableMethodNames

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        if (!context.evaluator.isMemberInClass(method, className)) {
            return
        }
        context.report(
            Incident(
                issue = issue,
                scope = node,
                location = context.getLocation(node),
                message = issue.getExplanation(TextFormat.TEXT),
                fix = quickFix()
            )
        )
    }

    private fun quickFix(): LintFix {
        return fix()
            .group()
            .apply {
                applicableMethodNames.forEach { applicableMethodName ->
                    replacementMethodNames.forEach { replacementMethodName ->
                        add(lintFix(applicableMethodName, replacementMethodName))
                    }
                }
            }
            .build()
    }

    private fun lintFix(applicableMethodName: String, replacementMethodName: String): LintFix {
        return fix()
            .replace()
            .text(applicableMethodName)
            .with(replacementMethodName)
            .imports(imports.first { it.contains(replacementMethodName) })
            .shortenNames()
            .reformat(true)
            .build()
    }
}
