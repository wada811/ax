package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetByteDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getByte"),
    replacementMethodNames = listOf("getByteOrNull", "getByteOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getByteOrNull", "com.wada811.adx.bundle.getByteOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetByte",
            briefDescription = "Use getByte",
            explanation = "Use getByteOrNull or getByteOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetByteDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}