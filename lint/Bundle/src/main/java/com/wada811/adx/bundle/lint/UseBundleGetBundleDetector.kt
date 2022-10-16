package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetBundleDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getBundle"),
    replacementMethodNames = listOf("getBundleOrNull", "getBundleOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getBundleOrNull", "com.wada811.adx.bundle.getBundleOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetBundle",
            briefDescription = "Use getBundle",
            explanation = "Use getBundleOrNull or getBundleOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetBundleDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}