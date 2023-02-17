package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetCharDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getChar"),
    replacementMethodNames = listOf("getCharOrNull", "getCharOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getCharOrNull", "com.wada811.ax.bundle.getCharOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetChar",
            briefDescription = "Use getChar",
            explanation = "Use getCharOrNull or getCharOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetCharDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
