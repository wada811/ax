package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetBooleanExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getBooleanExtra"),
    replacementMethodNames = listOf("getBooleanExtraOrNull", "getBooleanExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getBooleanExtraOrNull", "com.wada811.adx.intent.getBooleanExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetBooleanExtra",
            briefDescription = "Use getBooleanExtra",
            explanation = "Use getBooleanExtraOrNull or getBooleanExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetBooleanExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}