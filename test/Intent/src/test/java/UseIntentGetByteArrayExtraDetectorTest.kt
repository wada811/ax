import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetByteArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetByteArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetByteArrayExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetByteArrayExtra.kt:5: Warning: Use getByteArrayExtraOrNull or getByteArrayExtraOrThrow [UseIntentGetByteArrayExtra]
        intent.getByteArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetByteArrayExtra.kt line 5: Replace with getByteArrayExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getByteArrayExtraOrNull
@@ -5 +6
-         intent.getByteArrayExtra("")
+         intent.getByteArrayExtraOrNull("")
Fix for src/UseIntentGetByteArrayExtra.kt line 5: Replace with getByteArrayExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getByteArrayExtraOrThrow
@@ -5 +6
-         intent.getByteArrayExtra("")
+         intent.getByteArrayExtraOrThrow("")
    """.trimIndent()
}
