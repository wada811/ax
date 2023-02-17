package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetStringArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.BaseBundle",
    applicableMethodNames = listOf("getStringArray"),
    replacementMethodNames = listOf("getStringArrayOrNull", "getStringArrayOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getStringArrayOrNull", "com.wada811.ax.bundle.getStringArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetStringArray",
            briefDescription = "Use getStringArray",
            explanation = "Use getStringArrayOrNull or getStringArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetStringArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
