package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetCharArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getCharArray"),
    replacementMethodNames = listOf("getCharArrayOrNull", "getCharArrayOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getCharArrayOrNull", "com.wada811.adx.bundle.getCharArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetCharArray",
            briefDescription = "Use getCharArray",
            explanation = "Use getCharArrayOrNull or getCharArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetCharArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}