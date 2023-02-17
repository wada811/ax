package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetShortDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getShort"),
    replacementMethodNames = listOf("getShortOrNull", "getShortOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getShortOrNull", "com.wada811.ax.bundle.getShortOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetShort",
            briefDescription = "Use getShort",
            explanation = "Use getShortOrNull or getShortOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetShortDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
