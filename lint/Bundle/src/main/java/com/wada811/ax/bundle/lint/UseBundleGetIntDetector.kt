package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetIntDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.BaseBundle",
    applicableMethodNames = listOf("getInt"),
    replacementMethodNames = listOf("getIntOrNull", "getIntOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getIntOrNull", "com.wada811.ax.bundle.getIntOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetInt",
            briefDescription = "Use getInt",
            explanation = "Use getIntOrNull or getIntOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetIntDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
