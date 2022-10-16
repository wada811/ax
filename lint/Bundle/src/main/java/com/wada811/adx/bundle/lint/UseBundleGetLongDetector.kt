package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetLongDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.BaseBundle",
    applicableMethodNames = listOf("getLong"),
    replacementMethodNames = listOf("getLongOrNull", "getLongOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getLongOrNull", "com.wada811.adx.bundle.getLongOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetLong",
            briefDescription = "Use getLong",
            explanation = "Use getLongOrNull or getLongOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetLongDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}