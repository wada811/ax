package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetShortArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getShortArrayExtra"),
    replacementMethodNames = listOf("getShortArrayExtraOrNull", "getShortArrayExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getShortArrayExtraOrNull", "com.wada811.adx.intent.getShortArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetShortArrayExtra",
            briefDescription = "Use getShortArrayExtra",
            explanation = "Use getShortArrayExtraOrNull or getShortArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetShortArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}