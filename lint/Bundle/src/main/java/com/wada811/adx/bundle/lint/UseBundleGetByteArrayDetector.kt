package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetByteArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getByteArray"),
    replacementMethodNames = listOf("getByteArrayOrNull", "getByteArrayOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getByteArrayOrNull", "com.wada811.adx.bundle.getByteArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetByteArray",
            briefDescription = "Use getByteArray",
            explanation = "Use getByteArrayOrNull or getByteArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetByteArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}