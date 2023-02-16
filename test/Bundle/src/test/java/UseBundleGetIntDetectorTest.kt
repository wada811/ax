import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetIntDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetIntDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetInt.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetInt.kt:5: Warning: Use getIntOrNull or getIntOrThrow [UseBundleGetInt]
        bundle.getInt("")
        ~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetInt.kt line 5: Replace with getIntOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getIntOrNull
@@ -5 +6
-         bundle.getInt("")
+         bundle.getIntOrNull("")
Fix for src/UseBundleGetInt.kt line 5: Replace with getIntOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getIntOrThrow
@@ -5 +6
-         bundle.getInt("")
+         bundle.getIntOrThrow("")
    """.trimIndent()
}
