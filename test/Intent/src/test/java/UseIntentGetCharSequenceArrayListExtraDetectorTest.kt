import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetCharSequenceArrayListExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetCharSequenceArrayListExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetCharSequenceArrayListExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetCharSequenceArrayListExtra.kt:5: Warning: Use getCharSequenceArrayListExtraOrNull or getCharSequenceArrayListExtraOrThrow [UseIntentGetCharSequenceArrayListExtra]
        intent.getCharSequenceArrayListExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetCharSequenceArrayListExtra.kt line 5: Replace with getCharSequenceArrayListExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getCharSequenceArrayListExtraOrNull
@@ -5 +6
-         intent.getCharSequenceArrayListExtra("")
+         intent.getCharSequenceArrayListExtraOrNull("")
Fix for src/UseIntentGetCharSequenceArrayListExtra.kt line 5: Replace with getCharSequenceArrayListExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getCharSequenceArrayListExtraOrThrow
@@ -5 +6
-         intent.getCharSequenceArrayListExtra("")
+         intent.getCharSequenceArrayListExtraOrThrow("")
    """.trimIndent()
}
