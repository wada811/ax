package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetStringArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getStringArray"),
    replacementMethodNames = listOf("getStringArrayOrNull", "getStringArrayOrThrow"),
    imports = listOf("com.wada811.ax.intent.getStringArrayOrNull", "com.wada811.ax.intent.getStringArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetStringArray",
            briefDescription = "Use getStringArray",
            explanation = "Use getStringArrayOrNull or getStringArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetStringArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
