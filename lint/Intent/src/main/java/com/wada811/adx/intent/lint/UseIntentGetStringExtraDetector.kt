package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetStringExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getStringExtra"),
    replacementMethodNames = listOf("getStringExtraOrNull", "getStringExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getStringExtraOrNull", "com.wada811.adx.intent.getStringExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetStringExtra",
            briefDescription = "Use getStringExtra",
            explanation = "Use getStringExtraOrNull or getStringExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetStringExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}