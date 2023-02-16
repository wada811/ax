package com.wada811.ax.core.generator

import java.io.File

object TestSourceGenerator {
    fun Params.generate() {
        File("test/$upperClassName/src/test/java/Use${upperClassMethodName}DetectorTest.kt")
            .writeText(
                """
import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class Use${upperClassMethodName}DetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.$lowerClassName.lint.Use${upperClassMethodName}Detector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/Use$upperClassMethodName.kt")
    )
    override val expectedLint: String = ""${'"'}
src/Use$upperClassMethodName.kt:5: Warning: Use $replacementMethodNamesText [Use$upperClassMethodName]
        $lowerClassName.$applicableMethodName($methodParamsText)
        ${"~".repeat(lowerClassName.length + ".".length + applicableMethodName.length + "(".length + methodParamsText.length + ")".length)}
0 errors, 1 warnings
    ""${'"'}.trimIndent()
    override val expectedFixDiffs: String = ""${'"'}
${
                    replacementMethodNames.mapIndexed { index, replacementMethodName ->
                        """
Fix for src/Use$upperClassMethodName.kt line 5: Replace with ${replacementMethodName}:
@@ -1 +1
+ import ${imports[index]}
@@ -5 +6
-         $lowerClassName.$applicableMethodName($methodParamsText)
+         $lowerClassName.$replacementMethodName($methodParamsText)
        """.trimIndent()
                    }.joinToString("\n")
                }
    ""${'"'}.trimIndent()
}
            """.trimIndent()
            )
    }
}
