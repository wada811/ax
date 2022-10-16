package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetIntArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getIntArrayExtra"),
    replacementMethodNames = listOf("getIntArrayExtraOrNull", "getIntArrayExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getIntArrayExtraOrNull", "com.wada811.adx.intent.getIntArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetIntArrayExtra",
            briefDescription = "Use getIntArrayExtra",
            explanation = "Use getIntArrayExtraOrNull or getIntArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetIntArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}