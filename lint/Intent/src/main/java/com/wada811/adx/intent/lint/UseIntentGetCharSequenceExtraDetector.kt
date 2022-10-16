package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetCharSequenceExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getCharSequenceExtra"),
    replacementMethodNames = listOf("getCharSequenceExtraOrNull", "getCharSequenceExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getCharSequenceExtraOrNull", "com.wada811.adx.intent.getCharSequenceExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetCharSequenceExtra",
            briefDescription = "Use getCharSequenceExtra",
            explanation = "Use getCharSequenceExtraOrNull or getCharSequenceExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetCharSequenceExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}