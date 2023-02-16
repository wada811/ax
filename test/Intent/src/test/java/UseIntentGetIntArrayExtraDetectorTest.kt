import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetIntArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetIntArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetIntArrayExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetIntArrayExtra.kt:5: Warning: Use getIntArrayExtraOrNull or getIntArrayExtraOrThrow [UseIntentGetIntArrayExtra]
        intent.getIntArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetIntArrayExtra.kt line 5: Replace with getIntArrayExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getIntArrayExtraOrNull
@@ -5 +6
-         intent.getIntArrayExtra("")
+         intent.getIntArrayExtraOrNull("")
Fix for src/UseIntentGetIntArrayExtra.kt line 5: Replace with getIntArrayExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getIntArrayExtraOrThrow
@@ -5 +6
-         intent.getIntArrayExtra("")
+         intent.getIntArrayExtraOrThrow("")
    """.trimIndent()
}
