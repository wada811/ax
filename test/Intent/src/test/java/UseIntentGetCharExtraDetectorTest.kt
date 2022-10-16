import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetCharExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetCharExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetCharExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetCharExtra.kt:5: Warning: Use getCharExtraOrNull or getCharExtraOrThrow [UseIntentGetCharExtra]
        intent.getCharExtra("", 0.toChar())
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetCharExtra.kt line 5: Replace with getCharExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getCharExtraOrNull
@@ -5 +6
-         intent.getCharExtra("", 0.toChar())
+         intent.getCharExtraOrNull("", 0.toChar())
Fix for src/UseIntentGetCharExtra.kt line 5: Replace with getCharExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getCharExtraOrThrow
@@ -5 +6
-         intent.getCharExtra("", 0.toChar())
+         intent.getCharExtraOrThrow("", 0.toChar())
    """.trimIndent()
}