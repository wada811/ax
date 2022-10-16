import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetFloatArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetFloatArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetFloatArrayExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetFloatArrayExtra.kt:5: Warning: Use getFloatArrayExtraOrNull or getFloatArrayExtraOrThrow [UseIntentGetFloatArrayExtra]
        intent.getFloatArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetFloatArrayExtra.kt line 5: Replace with getFloatArrayExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getFloatArrayExtraOrNull
@@ -5 +6
-         intent.getFloatArrayExtra("")
+         intent.getFloatArrayExtraOrNull("")
Fix for src/UseIntentGetFloatArrayExtra.kt line 5: Replace with getFloatArrayExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getFloatArrayExtraOrThrow
@@ -5 +6
-         intent.getFloatArrayExtra("")
+         intent.getFloatArrayExtraOrThrow("")
    """.trimIndent()
}