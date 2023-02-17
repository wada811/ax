package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetFloatDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getFloat"),
    replacementMethodNames = listOf("getFloatOrNull", "getFloatOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getFloatOrNull", "com.wada811.ax.bundle.getFloatOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetFloat",
            briefDescription = "Use getFloat",
            explanation = "Use getFloatOrNull or getFloatOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetFloatDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
