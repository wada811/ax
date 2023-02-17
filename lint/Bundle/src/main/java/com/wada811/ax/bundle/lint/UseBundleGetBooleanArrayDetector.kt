package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetBooleanArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.BaseBundle",
    applicableMethodNames = listOf("getBooleanArray"),
    replacementMethodNames = listOf("getBooleanArrayOrNull", "getBooleanArrayOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getBooleanArrayOrNull", "com.wada811.ax.bundle.getBooleanArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetBooleanArray",
            briefDescription = "Use getBooleanArray",
            explanation = "Use getBooleanArrayOrNull or getBooleanArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetBooleanArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
