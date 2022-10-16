import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetFloatExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetFloatExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetFloatExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetFloatExtra.kt:5: Warning: Use getFloatExtraOrNull or getFloatExtraOrThrow [UseIntentGetFloatExtra]
        intent.getFloatExtra("", 0f)
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetFloatExtra.kt line 5: Replace with getFloatExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getFloatExtraOrNull
@@ -5 +6
-         intent.getFloatExtra("", 0f)
+         intent.getFloatExtraOrNull("", 0f)
Fix for src/UseIntentGetFloatExtra.kt line 5: Replace with getFloatExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getFloatExtraOrThrow
@@ -5 +6
-         intent.getFloatExtra("", 0f)
+         intent.getFloatExtraOrThrow("", 0f)
    """.trimIndent()
}