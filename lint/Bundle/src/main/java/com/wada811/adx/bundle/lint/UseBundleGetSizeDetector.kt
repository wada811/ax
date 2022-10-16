package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetSizeDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getSize"),
    replacementMethodNames = listOf("getSizeOrNull", "getSizeOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getSizeOrNull", "com.wada811.adx.bundle.getSizeOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetSize",
            briefDescription = "Use getSize",
            explanation = "Use getSizeOrNull or getSizeOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetSizeDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}