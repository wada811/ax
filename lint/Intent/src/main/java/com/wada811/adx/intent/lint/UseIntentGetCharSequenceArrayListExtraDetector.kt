package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetCharSequenceArrayListExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getCharSequenceArrayListExtra"),
    replacementMethodNames = listOf("getCharSequenceArrayListExtraOrNull", "getCharSequenceArrayListExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getCharSequenceArrayListExtraOrNull", "com.wada811.adx.intent.getCharSequenceArrayListExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetCharSequenceArrayListExtra",
            briefDescription = "Use getCharSequenceArrayListExtra",
            explanation = "Use getCharSequenceArrayListExtraOrNull or getCharSequenceArrayListExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetCharSequenceArrayListExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}