package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetShortArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getShortArray"),
    replacementMethodNames = listOf("getShortArrayOrNull", "getShortArrayOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getShortArrayOrNull", "com.wada811.adx.bundle.getShortArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetShortArray",
            briefDescription = "Use getShortArray",
            explanation = "Use getShortArrayOrNull or getShortArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetShortArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}