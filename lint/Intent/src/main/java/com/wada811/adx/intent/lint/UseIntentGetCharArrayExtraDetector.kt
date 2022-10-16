package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetCharArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getCharArrayExtra"),
    replacementMethodNames = listOf("getCharArrayExtraOrNull", "getCharArrayExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getCharArrayExtraOrNull", "com.wada811.adx.intent.getCharArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetCharArrayExtra",
            briefDescription = "Use getCharArrayExtra",
            explanation = "Use getCharArrayExtraOrNull or getCharArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetCharArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}