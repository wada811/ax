package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetBinderDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getBinder"),
    replacementMethodNames = listOf("getBinderOrNull", "getBinderOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getBinderOrNull", "com.wada811.adx.bundle.getBinderOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetBinder",
            briefDescription = "Use getBinder",
            explanation = "Use getBinderOrNull or getBinderOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetBinderDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}