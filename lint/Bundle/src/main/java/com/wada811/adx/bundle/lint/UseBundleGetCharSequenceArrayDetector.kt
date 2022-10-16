package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetCharSequenceArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getCharSequenceArray"),
    replacementMethodNames = listOf("getCharSequenceArrayOrNull", "getCharSequenceArrayOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getCharSequenceArrayOrNull", "com.wada811.adx.bundle.getCharSequenceArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetCharSequenceArray",
            briefDescription = "Use getCharSequenceArray",
            explanation = "Use getCharSequenceArrayOrNull or getCharSequenceArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetCharSequenceArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}