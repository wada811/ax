package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetDoubleDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.BaseBundle",
    applicableMethodNames = listOf("getDouble"),
    replacementMethodNames = listOf("getDoubleOrNull", "getDoubleOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getDoubleOrNull", "com.wada811.ax.bundle.getDoubleOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetDouble",
            briefDescription = "Use getDouble",
            explanation = "Use getDoubleOrNull or getDoubleOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetDoubleDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
