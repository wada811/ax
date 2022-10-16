package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetLongExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getLongExtra"),
    replacementMethodNames = listOf("getLongExtraOrNull", "getLongExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getLongExtraOrNull", "com.wada811.adx.intent.getLongExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetLongExtra",
            briefDescription = "Use getLongExtra",
            explanation = "Use getLongExtraOrNull or getLongExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetLongExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}