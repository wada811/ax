import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetIntArrayDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetIntArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetIntArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetIntArray.kt:5: Warning: Use getIntArrayOrNull or getIntArrayOrThrow [UseBundleGetIntArray]
        bundle.getIntArray("")
        ~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetIntArray.kt line 5: Replace with getIntArrayOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getIntArrayOrNull
@@ -5 +6
-         bundle.getIntArray("")
+         bundle.getIntArrayOrNull("")
Fix for src/UseBundleGetIntArray.kt line 5: Replace with getIntArrayOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getIntArrayOrThrow
@@ -5 +6
-         bundle.getIntArray("")
+         bundle.getIntArrayOrThrow("")
    """.trimIndent()
}
