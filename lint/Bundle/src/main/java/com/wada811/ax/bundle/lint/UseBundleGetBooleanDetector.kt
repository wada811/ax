package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetBooleanDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.BaseBundle",
    applicableMethodNames = listOf("getBoolean"),
    replacementMethodNames = listOf("getBooleanOrNull", "getBooleanOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getBooleanOrNull", "com.wada811.ax.bundle.getBooleanOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetBoolean",
            briefDescription = "Use getBoolean",
            explanation = "Use getBooleanOrNull or getBooleanOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetBooleanDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
