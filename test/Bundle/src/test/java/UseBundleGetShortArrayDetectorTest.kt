import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetShortArrayDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetShortArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetShortArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetShortArray.kt:5: Warning: Use getShortArrayOrNull or getShortArrayOrThrow [UseBundleGetShortArray]
        bundle.getShortArray("")
        ~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetShortArray.kt line 5: Replace with getShortArrayOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getShortArrayOrNull
@@ -5 +6
-         bundle.getShortArray("")
+         bundle.getShortArrayOrNull("")
Fix for src/UseBundleGetShortArray.kt line 5: Replace with getShortArrayOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getShortArrayOrThrow
@@ -5 +6
-         bundle.getShortArray("")
+         bundle.getShortArrayOrThrow("")
    """.trimIndent()
}
