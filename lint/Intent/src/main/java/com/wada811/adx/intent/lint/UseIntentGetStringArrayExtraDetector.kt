package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetStringArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getStringArrayExtra"),
    replacementMethodNames = listOf("getStringArrayExtraOrNull", "getStringArrayExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getStringArrayExtraOrNull", "com.wada811.adx.intent.getStringArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetStringArrayExtra",
            briefDescription = "Use getStringArrayExtra",
            explanation = "Use getStringArrayExtraOrNull or getStringArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetStringArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}