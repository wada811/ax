package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetFloatExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getFloatExtra"),
    replacementMethodNames = listOf("getFloatExtraOrNull", "getFloatExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getFloatExtraOrNull", "com.wada811.adx.intent.getFloatExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetFloatExtra",
            briefDescription = "Use getFloatExtra",
            explanation = "Use getFloatExtraOrNull or getFloatExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetFloatExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}