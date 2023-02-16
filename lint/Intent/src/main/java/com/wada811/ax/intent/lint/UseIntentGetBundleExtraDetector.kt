package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetBundleExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getBundleExtra"),
    replacementMethodNames = listOf("getBundleExtraOrNull", "getBundleExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getBundleExtraOrNull", "com.wada811.ax.intent.getBundleExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetBundleExtra",
            briefDescription = "Use getBundleExtra",
            explanation = "Use getBundleExtraOrNull or getBundleExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetBundleExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
