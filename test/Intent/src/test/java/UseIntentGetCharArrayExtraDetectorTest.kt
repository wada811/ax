import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetCharArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetCharArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetCharArrayExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetCharArrayExtra.kt:5: Warning: Use getCharArrayExtraOrNull or getCharArrayExtraOrThrow [UseIntentGetCharArrayExtra]
        intent.getCharArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetCharArrayExtra.kt line 5: Replace with getCharArrayExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getCharArrayExtraOrNull
@@ -5 +6
-         intent.getCharArrayExtra("")
+         intent.getCharArrayExtraOrNull("")
Fix for src/UseIntentGetCharArrayExtra.kt line 5: Replace with getCharArrayExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getCharArrayExtraOrThrow
@@ -5 +6
-         intent.getCharArrayExtra("")
+         intent.getCharArrayExtraOrThrow("")
    """.trimIndent()
}