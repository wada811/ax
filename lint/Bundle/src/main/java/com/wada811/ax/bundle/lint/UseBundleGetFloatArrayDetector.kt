package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetFloatArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getFloatArray"),
    replacementMethodNames = listOf("getFloatArrayOrNull", "getFloatArrayOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getFloatArrayOrNull", "com.wada811.ax.bundle.getFloatArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetFloatArray",
            briefDescription = "Use getFloatArray",
            explanation = "Use getFloatArrayOrNull or getFloatArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetFloatArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
