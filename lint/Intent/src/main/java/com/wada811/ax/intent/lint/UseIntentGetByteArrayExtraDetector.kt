package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetByteArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getByteArrayExtra"),
    replacementMethodNames = listOf("getByteArrayExtraOrNull", "getByteArrayExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getByteArrayExtraOrNull", "com.wada811.ax.intent.getByteArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetByteArrayExtra",
            briefDescription = "Use getByteArrayExtra",
            explanation = "Use getByteArrayExtraOrNull or getByteArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetByteArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
