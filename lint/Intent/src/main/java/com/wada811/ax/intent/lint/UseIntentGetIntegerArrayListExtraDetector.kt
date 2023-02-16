package com.wada811.ax.intent.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class UseIntentGetIntegerArrayListExtraDetector : MethodDetector(
    issue = ISSUE,
    className = "android.content.Intent",
    applicableMethodNames = listOf("getIntegerArrayListExtra"),
    replacementMethodNames = listOf("getIntegerArrayListExtraOrNull", "getIntegerArrayListExtraOrThrow"),
    imports = listOf("com.wada811.ax.intent.getIntegerArrayListExtraOrNull", "com.wada811.ax.intent.getIntegerArrayListExtraOrThrow")
) {
    companion object {
        val ISSUE = Issue.create(
            id = "UseIntentGetIntegerArrayListExtra",
            briefDescription = "Use getIntegerArrayListExtra",
            explanation = "Use getIntegerArrayListExtraOrNull or getIntegerArrayListExtraOrThrow",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                UseIntentGetIntegerArrayListExtraDetector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
