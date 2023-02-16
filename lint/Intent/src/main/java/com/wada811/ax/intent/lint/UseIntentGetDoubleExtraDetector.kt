package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetDoubleExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getDoubleExtra"),
    replacementMethodNames = listOf("getDoubleExtraOrNull", "getDoubleExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getDoubleExtraOrNull", "com.wada811.ax.intent.getDoubleExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetDoubleExtra",
            briefDescription = "Use getDoubleExtra",
            explanation = "Use getDoubleExtraOrNull or getDoubleExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetDoubleExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
