import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetShortExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetShortExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetShortExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetShortExtra.kt:5: Warning: Use getShortExtraOrNull or getShortExtraOrThrow [UseIntentGetShortExtra]
        intent.getShortExtra("", 0)
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetShortExtra.kt line 5: Replace with getShortExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getShortExtraOrNull
@@ -5 +6
-         intent.getShortExtra("", 0)
+         intent.getShortExtraOrNull("", 0)
Fix for src/UseIntentGetShortExtra.kt line 5: Replace with getShortExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getShortExtraOrThrow
@@ -5 +6
-         intent.getShortExtra("", 0)
+         intent.getShortExtraOrThrow("", 0)
    """.trimIndent()
}
