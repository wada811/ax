package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetStringDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getString"),
    replacementMethodNames = listOf("getStringOrNull", "getStringOrThrow"),
    imports = listOf("com.wada811.adx.intent.getStringOrNull", "com.wada811.adx.intent.getStringOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetString",
            briefDescription = "Use getString",
            explanation = "Use getStringOrNull or getStringOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetStringDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}