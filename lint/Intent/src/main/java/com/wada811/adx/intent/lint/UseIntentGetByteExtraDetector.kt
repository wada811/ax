package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetByteExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getByteExtra"),
    replacementMethodNames = listOf("getByteExtraOrNull", "getByteExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getByteExtraOrNull", "com.wada811.adx.intent.getByteExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetByteExtra",
            briefDescription = "Use getByteExtra",
            explanation = "Use getByteExtraOrNull or getByteExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetByteExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}