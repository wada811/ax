import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetBooleanArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetBooleanArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetBooleanArrayExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetBooleanArrayExtra.kt:5: Warning: Use getBooleanArrayExtraOrNull or getBooleanArrayExtraOrThrow [UseIntentGetBooleanArrayExtra]
        intent.getBooleanArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetBooleanArrayExtra.kt line 5: Replace with getBooleanArrayExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getBooleanArrayExtraOrNull
@@ -5 +6
-         intent.getBooleanArrayExtra("")
+         intent.getBooleanArrayExtraOrNull("")
Fix for src/UseIntentGetBooleanArrayExtra.kt line 5: Replace with getBooleanArrayExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getBooleanArrayExtraOrThrow
@@ -5 +6
-         intent.getBooleanArrayExtra("")
+         intent.getBooleanArrayExtraOrThrow("")
    """.trimIndent()
}