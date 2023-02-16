import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetCharArrayDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetCharArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetCharArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetCharArray.kt:5: Warning: Use getCharArrayOrNull or getCharArrayOrThrow [UseBundleGetCharArray]
        bundle.getCharArray("")
        ~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetCharArray.kt line 5: Replace with getCharArrayOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getCharArrayOrNull
@@ -5 +6
-         bundle.getCharArray("")
+         bundle.getCharArrayOrNull("")
Fix for src/UseBundleGetCharArray.kt line 5: Replace with getCharArrayOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getCharArrayOrThrow
@@ -5 +6
-         bundle.getCharArray("")
+         bundle.getCharArrayOrThrow("")
    """.trimIndent()
}
