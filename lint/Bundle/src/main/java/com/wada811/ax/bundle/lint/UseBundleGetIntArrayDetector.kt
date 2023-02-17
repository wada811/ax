package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetIntArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.BaseBundle",
    applicableMethodNames = listOf("getIntArray"),
    replacementMethodNames = listOf("getIntArrayOrNull", "getIntArrayOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getIntArrayOrNull", "com.wada811.ax.bundle.getIntArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetIntArray",
            briefDescription = "Use getIntArray",
            explanation = "Use getIntArrayOrNull or getIntArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetIntArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
