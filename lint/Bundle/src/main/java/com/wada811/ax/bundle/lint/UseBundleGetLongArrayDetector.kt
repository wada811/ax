package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetLongArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.BaseBundle",
    applicableMethodNames = listOf("getLongArray"),
    replacementMethodNames = listOf("getLongArrayOrNull", "getLongArrayOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getLongArrayOrNull", "com.wada811.ax.bundle.getLongArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetLongArray",
            briefDescription = "Use getLongArray",
            explanation = "Use getLongArrayOrNull or getLongArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetLongArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
