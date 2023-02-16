import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetDoubleExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetDoubleExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetDoubleExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetDoubleExtra.kt:5: Warning: Use getDoubleExtraOrNull or getDoubleExtraOrThrow [UseIntentGetDoubleExtra]
        intent.getDoubleExtra("", 0.0)
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetDoubleExtra.kt line 5: Replace with getDoubleExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getDoubleExtraOrNull
@@ -5 +6
-         intent.getDoubleExtra("", 0.0)
+         intent.getDoubleExtraOrNull("", 0.0)
Fix for src/UseIntentGetDoubleExtra.kt line 5: Replace with getDoubleExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getDoubleExtraOrThrow
@@ -5 +6
-         intent.getDoubleExtra("", 0.0)
+         intent.getDoubleExtraOrThrow("", 0.0)
    """.trimIndent()
}
