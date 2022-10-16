import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetCharSequenceExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetCharSequenceExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetCharSequenceExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetCharSequenceExtra.kt:5: Warning: Use getCharSequenceExtraOrNull or getCharSequenceExtraOrThrow [UseIntentGetCharSequenceExtra]
        intent.getCharSequenceExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetCharSequenceExtra.kt line 5: Replace with getCharSequenceExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getCharSequenceExtraOrNull
@@ -5 +6
-         intent.getCharSequenceExtra("")
+         intent.getCharSequenceExtraOrNull("")
Fix for src/UseIntentGetCharSequenceExtra.kt line 5: Replace with getCharSequenceExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getCharSequenceExtraOrThrow
@@ -5 +6
-         intent.getCharSequenceExtra("")
+         intent.getCharSequenceExtraOrThrow("")
    """.trimIndent()
}