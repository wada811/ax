package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetIntExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getIntExtra"),
    replacementMethodNames = listOf("getIntExtraOrNull", "getIntExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getIntExtraOrNull", "com.wada811.ax.intent.getIntExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetIntExtra",
            briefDescription = "Use getIntExtra",
            explanation = "Use getIntExtraOrNull or getIntExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetIntExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
