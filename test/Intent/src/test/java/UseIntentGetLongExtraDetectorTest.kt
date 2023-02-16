import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetLongExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetLongExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetLongExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetLongExtra.kt:5: Warning: Use getLongExtraOrNull or getLongExtraOrThrow [UseIntentGetLongExtra]
        intent.getLongExtra("", 0L)
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetLongExtra.kt line 5: Replace with getLongExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getLongExtraOrNull
@@ -5 +6
-         intent.getLongExtra("", 0L)
+         intent.getLongExtraOrNull("", 0L)
Fix for src/UseIntentGetLongExtra.kt line 5: Replace with getLongExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getLongExtraOrThrow
@@ -5 +6
-         intent.getLongExtra("", 0L)
+         intent.getLongExtraOrThrow("", 0L)
    """.trimIndent()
}
