import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetDoubleArrayDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetDoubleArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetDoubleArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetDoubleArray.kt:5: Warning: Use getDoubleArrayOrNull or getDoubleArrayOrThrow [UseBundleGetDoubleArray]
        bundle.getDoubleArray("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetDoubleArray.kt line 5: Replace with getDoubleArrayOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getDoubleArrayOrNull
@@ -5 +6
-         bundle.getDoubleArray("")
+         bundle.getDoubleArrayOrNull("")
Fix for src/UseBundleGetDoubleArray.kt line 5: Replace with getDoubleArrayOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getDoubleArrayOrThrow
@@ -5 +6
-         bundle.getDoubleArray("")
+         bundle.getDoubleArrayOrThrow("")
    """.trimIndent()
}
