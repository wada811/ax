package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetStringDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.BaseBundle",
    applicableMethodNames = listOf("getString"),
    replacementMethodNames = listOf("getStringOrNull", "getStringOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getStringOrNull", "com.wada811.ax.bundle.getStringOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetString",
            briefDescription = "Use getString",
            explanation = "Use getStringOrNull or getStringOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetStringDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
