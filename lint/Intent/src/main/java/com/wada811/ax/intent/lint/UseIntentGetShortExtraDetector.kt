package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetShortExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getShortExtra"),
    replacementMethodNames = listOf("getShortExtraOrNull", "getShortExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getShortExtraOrNull", "com.wada811.ax.intent.getShortExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetShortExtra",
            briefDescription = "Use getShortExtra",
            explanation = "Use getShortExtraOrNull or getShortExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetShortExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
