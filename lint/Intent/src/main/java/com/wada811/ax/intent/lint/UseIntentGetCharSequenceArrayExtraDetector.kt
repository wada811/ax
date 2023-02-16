package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetCharSequenceArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getCharSequenceArrayExtra"),
    replacementMethodNames = listOf("getCharSequenceArrayExtraOrNull", "getCharSequenceArrayExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getCharSequenceArrayExtraOrNull", "com.wada811.ax.intent.getCharSequenceArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetCharSequenceArrayExtra",
            briefDescription = "Use getCharSequenceArrayExtra",
            explanation = "Use getCharSequenceArrayExtraOrNull or getCharSequenceArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetCharSequenceArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
