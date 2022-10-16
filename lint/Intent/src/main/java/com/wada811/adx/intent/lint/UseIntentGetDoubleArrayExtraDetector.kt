package com.wada811.adx.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.adx.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetDoubleArrayExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getDoubleArrayExtra"),
    replacementMethodNames = listOf("getDoubleArrayExtraOrNull", "getDoubleArrayExtraOrThrow"),
    imports = listOf("com.wada811.adx.intent.getDoubleArrayExtraOrNull", "com.wada811.adx.intent.getDoubleArrayExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetDoubleArrayExtra",
            briefDescription = "Use getDoubleArrayExtra",
            explanation = "Use getDoubleArrayExtraOrNull or getDoubleArrayExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetDoubleArrayExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}