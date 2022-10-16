import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetBooleanExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetBooleanExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetBooleanExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetBooleanExtra.kt:5: Warning: Use getBooleanExtraOrNull or getBooleanExtraOrThrow [UseIntentGetBooleanExtra]
        intent.getBooleanExtra("", false)
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetBooleanExtra.kt line 5: Replace with getBooleanExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getBooleanExtraOrNull
@@ -5 +6
-         intent.getBooleanExtra("", false)
+         intent.getBooleanExtraOrNull("", false)
Fix for src/UseIntentGetBooleanExtra.kt line 5: Replace with getBooleanExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getBooleanExtraOrThrow
@@ -5 +6
-         intent.getBooleanExtra("", false)
+         intent.getBooleanExtraOrThrow("", false)
    """.trimIndent()
}