package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetFloatArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getFloatArrayExtra"),
    replacementMethodNames = listOf("getFloatArrayExtraOrNull", "getFloatArrayExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getFloatArrayExtraOrNull", "com.wada811.ax.intent.getFloatArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetFloatArrayExtra",
            briefDescription = "Use getFloatArrayExtra",
            explanation = "Use getFloatArrayExtraOrNull or getFloatArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetFloatArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
