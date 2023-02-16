import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetFloatDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetFloatDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetFloat.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetFloat.kt:5: Warning: Use getFloatOrNull or getFloatOrThrow [UseBundleGetFloat]
        bundle.getFloat("")
        ~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetFloat.kt line 5: Replace with getFloatOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getFloatOrNull
@@ -5 +6
-         bundle.getFloat("")
+         bundle.getFloatOrNull("")
Fix for src/UseBundleGetFloat.kt line 5: Replace with getFloatOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getFloatOrThrow
@@ -5 +6
-         bundle.getFloat("")
+         bundle.getFloatOrThrow("")
    """.trimIndent()
}
