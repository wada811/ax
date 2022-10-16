import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetCharSequenceArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetCharSequenceArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetCharSequenceArrayExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetCharSequenceArrayExtra.kt:5: Warning: Use getCharSequenceArrayExtraOrNull or getCharSequenceArrayExtraOrThrow [UseIntentGetCharSequenceArrayExtra]
        intent.getCharSequenceArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetCharSequenceArrayExtra.kt line 5: Replace with getCharSequenceArrayExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getCharSequenceArrayExtraOrNull
@@ -5 +6
-         intent.getCharSequenceArrayExtra("")
+         intent.getCharSequenceArrayExtraOrNull("")
Fix for src/UseIntentGetCharSequenceArrayExtra.kt line 5: Replace with getCharSequenceArrayExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getCharSequenceArrayExtraOrThrow
@@ -5 +6
-         intent.getCharSequenceArrayExtra("")
+         intent.getCharSequenceArrayExtraOrThrow("")
    """.trimIndent()
}