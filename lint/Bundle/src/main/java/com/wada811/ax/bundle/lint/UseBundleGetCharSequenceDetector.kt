package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetCharSequenceDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getCharSequence"),
    replacementMethodNames = listOf("getCharSequenceOrNull", "getCharSequenceOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getCharSequenceOrNull", "com.wada811.ax.bundle.getCharSequenceOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetCharSequence",
            briefDescription = "Use getCharSequence",
            explanation = "Use getCharSequenceOrNull or getCharSequenceOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetCharSequenceDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
