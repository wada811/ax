package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetStringArrayListDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getStringArrayList"),
    replacementMethodNames = listOf("getStringArrayListOrNull", "getStringArrayListOrThrow"),
    imports = listOf("com.wada811.ax.intent.getStringArrayListOrNull", "com.wada811.ax.intent.getStringArrayListOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetStringArrayList",
            briefDescription = "Use getStringArrayList",
            explanation = "Use getStringArrayListOrNull or getStringArrayListOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetStringArrayListDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
