package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetCharExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getCharExtra"),
    replacementMethodNames = listOf("getCharExtraOrNull", "getCharExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getCharExtraOrNull", "com.wada811.adx.intent.getCharExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetCharExtra",
            briefDescription = "Use getCharExtra",
            explanation = "Use getCharExtraOrNull or getCharExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetCharExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}