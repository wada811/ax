import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseIntentGetBundleExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.intent.lint.UseIntentGetBundleExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetBundleExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetBundleExtra.kt:5: Warning: Use getBundleExtraOrNull or getBundleExtraOrThrow [UseIntentGetBundleExtra]
        intent.getBundleExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetBundleExtra.kt line 5: Replace with getBundleExtraOrNull:
@@ -1 +1
+ import com.wada811.ax.intent.getBundleExtraOrNull
@@ -5 +6
-         intent.getBundleExtra("")
+         intent.getBundleExtraOrNull("")
Fix for src/UseIntentGetBundleExtra.kt line 5: Replace with getBundleExtraOrThrow:
@@ -1 +1
+ import com.wada811.ax.intent.getBundleExtraOrThrow
@@ -5 +6
-         intent.getBundleExtra("")
+         intent.getBundleExtraOrThrow("")
    """.trimIndent()
}
