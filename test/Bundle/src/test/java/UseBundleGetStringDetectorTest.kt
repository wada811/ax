import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetStringDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetStringDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetString.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetString.kt:5: Warning: Use getStringOrNull or getStringOrThrow [UseBundleGetString]
        bundle.getString("")
        ~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetString.kt line 5: Replace with getStringOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getStringOrNull
@@ -5 +6
-         bundle.getString("")
+         bundle.getStringOrNull("")
Fix for src/UseBundleGetString.kt line 5: Replace with getStringOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getStringOrThrow
@@ -5 +6
-         bundle.getString("")
+         bundle.getStringOrThrow("")
    """.trimIndent()
}
