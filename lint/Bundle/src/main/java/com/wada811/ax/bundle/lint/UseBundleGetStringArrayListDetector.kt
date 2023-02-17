package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetStringArrayListDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getStringArrayList"),
    replacementMethodNames = listOf("getStringArrayListOrNull", "getStringArrayListOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getStringArrayListOrNull", "com.wada811.ax.bundle.getStringArrayListOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetStringArrayList",
            briefDescription = "Use getStringArrayList",
            explanation = "Use getStringArrayListOrNull or getStringArrayListOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetStringArrayListDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
