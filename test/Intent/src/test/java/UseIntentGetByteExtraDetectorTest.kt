import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetByteExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetByteExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetByteExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetByteExtra.kt:5: Warning: Use getByteExtraOrNull or getByteExtraOrThrow [UseIntentGetByteExtra]
        intent.getByteExtra("", 0)
        ~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetByteExtra.kt line 5: Replace with getByteExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getByteExtraOrNull
@@ -5 +6
-         intent.getByteExtra("", 0)
+         intent.getByteExtraOrNull("", 0)
Fix for src/UseIntentGetByteExtra.kt line 5: Replace with getByteExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getByteExtraOrThrow
@@ -5 +6
-         intent.getByteExtra("", 0)
+         intent.getByteExtraOrThrow("", 0)
    """.trimIndent()
}
