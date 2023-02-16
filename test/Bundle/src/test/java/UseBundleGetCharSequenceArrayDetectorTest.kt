import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetCharSequenceArrayDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetCharSequenceArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetCharSequenceArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetCharSequenceArray.kt:5: Warning: Use getCharSequenceArrayOrNull or getCharSequenceArrayOrThrow [UseBundleGetCharSequenceArray]
        bundle.getCharSequenceArray("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetCharSequenceArray.kt line 5: Replace with getCharSequenceArrayOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getCharSequenceArrayOrNull
@@ -5 +6
-         bundle.getCharSequenceArray("")
+         bundle.getCharSequenceArrayOrNull("")
Fix for src/UseBundleGetCharSequenceArray.kt line 5: Replace with getCharSequenceArrayOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getCharSequenceArrayOrThrow
@@ -5 +6
-         bundle.getCharSequenceArray("")
+         bundle.getCharSequenceArrayOrThrow("")
    """.trimIndent()
}
