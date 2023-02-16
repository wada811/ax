import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetDoubleArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetDoubleArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetDoubleArrayExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetDoubleArrayExtra.kt:5: Warning: Use getDoubleArrayExtraOrNull or getDoubleArrayExtraOrThrow [UseIntentGetDoubleArrayExtra]
        intent.getDoubleArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetDoubleArrayExtra.kt line 5: Replace with getDoubleArrayExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getDoubleArrayExtraOrNull
@@ -5 +6
-         intent.getDoubleArrayExtra("")
+         intent.getDoubleArrayExtraOrNull("")
Fix for src/UseIntentGetDoubleArrayExtra.kt line 5: Replace with getDoubleArrayExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getDoubleArrayExtraOrThrow
@@ -5 +6
-         intent.getDoubleArrayExtra("")
+         intent.getDoubleArrayExtraOrThrow("")
    """.trimIndent()
}
