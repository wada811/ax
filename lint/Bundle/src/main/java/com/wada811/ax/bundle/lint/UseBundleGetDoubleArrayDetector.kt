package com.wada811.ax.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetDoubleArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.BaseBundle",
    applicableMethodNames = listOf("getDoubleArray"),
    replacementMethodNames = listOf("getDoubleArrayOrNull", "getDoubleArrayOrThrow"),
    imports = listOf("com.wada811.ax.bundle.getDoubleArrayOrNull", "com.wada811.ax.bundle.getDoubleArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetDoubleArray",
            briefDescription = "Use getDoubleArray",
            explanation = "Use getDoubleArrayOrNull or getDoubleArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetDoubleArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
