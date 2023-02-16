package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetBooleanArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getBooleanArrayExtra"),
    replacementMethodNames = listOf("getBooleanArrayExtraOrNull", "getBooleanArrayExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getBooleanArrayExtraOrNull", "com.wada811.ax.intent.getBooleanArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetBooleanArrayExtra",
            briefDescription = "Use getBooleanArrayExtra",
            explanation = "Use getBooleanArrayExtraOrNull or getBooleanArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetBooleanArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
