package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetLongArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getLongArrayExtra"),
    replacementMethodNames = listOf("getLongArrayExtraOrNull", "getLongArrayExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getLongArrayExtraOrNull", "com.wada811.ax.intent.getLongArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetLongArrayExtra",
            briefDescription = "Use getLongArrayExtra",
            explanation = "Use getLongArrayExtraOrNull or getLongArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetLongArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
