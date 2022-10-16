package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetCharSequenceArrayListDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getCharSequenceArrayList"),
    replacementMethodNames = listOf("getCharSequenceArrayListOrNull", "getCharSequenceArrayListOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getCharSequenceArrayListOrNull", "com.wada811.adx.bundle.getCharSequenceArrayListOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetCharSequenceArrayList",
            briefDescription = "Use getCharSequenceArrayList",
            explanation = "Use getCharSequenceArrayListOrNull or getCharSequenceArrayListOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetCharSequenceArrayListDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}