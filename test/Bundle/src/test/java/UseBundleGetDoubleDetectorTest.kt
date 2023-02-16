import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetDoubleDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetDoubleDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetDouble.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetDouble.kt:5: Warning: Use getDoubleOrNull or getDoubleOrThrow [UseBundleGetDouble]
        bundle.getDouble("")
        ~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetDouble.kt line 5: Replace with getDoubleOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getDoubleOrNull
@@ -5 +6
-         bundle.getDouble("")
+         bundle.getDoubleOrNull("")
Fix for src/UseBundleGetDouble.kt line 5: Replace with getDoubleOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getDoubleOrThrow
@@ -5 +6
-         bundle.getDouble("")
+         bundle.getDoubleOrThrow("")
    """.trimIndent()
}
