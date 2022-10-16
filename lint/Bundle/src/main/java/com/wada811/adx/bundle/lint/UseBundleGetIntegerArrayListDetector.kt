package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetIntegerArrayListDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getIntegerArrayList"),
    replacementMethodNames = listOf("getIntegerArrayListOrNull", "getIntegerArrayListOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getIntegerArrayListOrNull", "com.wada811.adx.bundle.getIntegerArrayListOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetIntegerArrayList",
            briefDescription = "Use getIntegerArrayList",
            explanation = "Use getIntegerArrayListOrNull or getIntegerArrayListOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetIntegerArrayListDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}