import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetIntegerArrayListExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetIntegerArrayListExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetIntegerArrayListExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetIntegerArrayListExtra.kt:5: Warning: Use getIntegerArrayListExtraOrNull or getIntegerArrayListExtraOrThrow [UseIntentGetIntegerArrayListExtra]
        intent.getIntegerArrayListExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetIntegerArrayListExtra.kt line 5: Replace with getIntegerArrayListExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getIntegerArrayListExtraOrNull
@@ -5 +6
-         intent.getIntegerArrayListExtra("")
+         intent.getIntegerArrayListExtraOrNull("")
Fix for src/UseIntentGetIntegerArrayListExtra.kt line 5: Replace with getIntegerArrayListExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getIntegerArrayListExtraOrThrow
@@ -5 +6
-         intent.getIntegerArrayListExtra("")
+         intent.getIntegerArrayListExtraOrThrow("")
    """.trimIndent()
}
