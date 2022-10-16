import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetStringExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetStringExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetStringExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetStringExtra.kt:5: Warning: Use getStringExtraOrNull or getStringExtraOrThrow [UseIntentGetStringExtra]
        intent.getStringExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetStringExtra.kt line 5: Replace with getStringExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getStringExtraOrNull
@@ -5 +6
-         intent.getStringExtra("")
+         intent.getStringExtraOrNull("")
Fix for src/UseIntentGetStringExtra.kt line 5: Replace with getStringExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getStringExtraOrThrow
@@ -5 +6
-         intent.getStringExtra("")
+         intent.getStringExtraOrThrow("")
    """.trimIndent()
}