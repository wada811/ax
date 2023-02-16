import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetLongArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetLongArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetLongArrayExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetLongArrayExtra.kt:5: Warning: Use getLongArrayExtraOrNull or getLongArrayExtraOrThrow [UseIntentGetLongArrayExtra]
        intent.getLongArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetLongArrayExtra.kt line 5: Replace with getLongArrayExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getLongArrayExtraOrNull
@@ -5 +6
-         intent.getLongArrayExtra("")
+         intent.getLongArrayExtraOrNull("")
Fix for src/UseIntentGetLongArrayExtra.kt line 5: Replace with getLongArrayExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getLongArrayExtraOrThrow
@@ -5 +6
-         intent.getLongArrayExtra("")
+         intent.getLongArrayExtraOrThrow("")
    """.trimIndent()
}
