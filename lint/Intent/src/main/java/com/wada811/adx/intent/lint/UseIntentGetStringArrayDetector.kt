package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetStringArrayDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getStringArray"),
    replacementMethodNames = listOf("getStringArrayOrNull", "getStringArrayOrThrow"),
    imports = listOf("com.wada811.adx.intent.getStringArrayOrNull", "com.wada811.adx.intent.getStringArrayOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetStringArray",
            briefDescription = "Use getStringArray",
            explanation = "Use getStringArrayOrNull or getStringArrayOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetStringArrayDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}