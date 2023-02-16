package com.wada811.ax.core.generator

import java.io.File

object DetectorGenerator {
    fun Params.generate() {
        File("lint/$upperClassName/src/main/java/com/wada811/ax/$lowerClassName/lint/Use${upperClassMethodName}Detector.kt")
            .writeText(
                """
package com.wada811.ax.$lowerClassName.lint

import com.android.tools.lint.detector.api.*
import com.wada811.ax.core.lint.MethodDetector

@Suppress("UnstableApiUsage")
class Use${upperClassMethodName}Detector : MethodDetector(
    issue = ISSUE,
    className = "$targetClassName",
    applicableMethodNames = listOf("$applicableMethodName"),
    replacementMethodNames = listOf(${replacementMethodNameValues}),
    imports = listOf($importsText)
) {
    companion object {
        val ISSUE = Issue.create(
            id = "Use$upperClassMethodName",
            briefDescription = "Use $applicableMethodName",
            explanation = "Use $replacementMethodNamesText",
            category = Category.PRODUCTIVITY,
            priority = 5,
            severity = Severity.WARNING,
            androidSpecific = true,
            implementation = Implementation(
                Use${upperClassMethodName}Detector::class.java,
                Scope.JAVA_FILE_SCOPE,
            ),
        )
    }
}
            """.trimIndent()
            )
    }
}
