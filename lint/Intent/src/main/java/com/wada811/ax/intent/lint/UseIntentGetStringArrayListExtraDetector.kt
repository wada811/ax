package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetStringArrayListExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getStringArrayListExtra"),
    replacementMethodNames = listOf("getStringArrayListExtraOrNull", "getStringArrayListExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getStringArrayListExtraOrNull", "com.wada811.ax.intent.getStringArrayListExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetStringArrayListExtra",
            briefDescription = "Use getStringArrayListExtra",
            explanation = "Use getStringArrayListExtraOrNull or getStringArrayListExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetStringArrayListExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
