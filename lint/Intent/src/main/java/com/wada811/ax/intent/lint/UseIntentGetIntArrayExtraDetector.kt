package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetIntArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getIntArrayExtra"),
    replacementMethodNames = listOf("getIntArrayExtraOrNull", "getIntArrayExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getIntArrayExtraOrNull", "com.wada811.ax.intent.getIntArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetIntArrayExtra",
            briefDescription = "Use getIntArrayExtra",
            explanation = "Use getIntArrayExtraOrNull or getIntArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetIntArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
