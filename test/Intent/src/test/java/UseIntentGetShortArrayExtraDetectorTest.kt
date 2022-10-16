import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetShortArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetShortArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetShortArrayExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetShortArrayExtra.kt:5: Warning: Use getShortArrayExtraOrNull or getShortArrayExtraOrThrow [UseIntentGetShortArrayExtra]
        intent.getShortArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetShortArrayExtra.kt line 5: Replace with getShortArrayExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getShortArrayExtraOrNull
@@ -5 +6
-         intent.getShortArrayExtra("")
+         intent.getShortArrayExtraOrNull("")
Fix for src/UseIntentGetShortArrayExtra.kt line 5: Replace with getShortArrayExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getShortArrayExtraOrThrow
@@ -5 +6
-         intent.getShortArrayExtra("")
+         intent.getShortArrayExtraOrThrow("")
    """.trimIndent()
}