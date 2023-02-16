import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetIntExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetIntExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetIntExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetIntExtra.kt:5: Warning: Use getIntExtraOrNull or getIntExtraOrThrow [UseIntentGetIntExtra]
        intent.getIntExtra("", 0)
        ~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetIntExtra.kt line 5: Replace with getIntExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getIntExtraOrNull
@@ -5 +6
-         intent.getIntExtra("", 0)
+         intent.getIntExtraOrNull("", 0)
Fix for src/UseIntentGetIntExtra.kt line 5: Replace with getIntExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getIntExtraOrThrow
@@ -5 +6
-         intent.getIntExtra("", 0)
+         intent.getIntExtraOrThrow("", 0)
    """.trimIndent()
}
