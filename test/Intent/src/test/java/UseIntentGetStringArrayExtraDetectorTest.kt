import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetStringArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetStringArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetStringArrayExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetStringArrayExtra.kt:5: Warning: Use getStringArrayExtraOrNull or getStringArrayExtraOrThrow [UseIntentGetStringArrayExtra]
        intent.getStringArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetStringArrayExtra.kt line 5: Replace with getStringArrayExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getStringArrayExtraOrNull
@@ -5 +6
-         intent.getStringArrayExtra("")
+         intent.getStringArrayExtraOrNull("")
Fix for src/UseIntentGetStringArrayExtra.kt line 5: Replace with getStringArrayExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getStringArrayExtraOrThrow
@@ -5 +6
-         intent.getStringArrayExtra("")
+         intent.getStringArrayExtraOrThrow("")
    """.trimIndent()
}
