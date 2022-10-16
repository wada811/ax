package com.wada811.adx.bundle.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseBundleGetSizeFDetector : MethodDetector(
    issue = ISSUE,
    className = "android.os.Bundle",
    applicableMethodNames = listOf("getSizeF"),
    replacementMethodNames = listOf("getSizeFOrNull", "getSizeFOrThrow"),
    imports = listOf("com.wada811.adx.bundle.getSizeFOrNull", "com.wada811.adx.bundle.getSizeFOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseBundleGetSizeF",
            briefDescription = "Use getSizeF",
            explanation = "Use getSizeFOrNull or getSizeFOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseBundleGetSizeFDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}