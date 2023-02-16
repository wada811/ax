import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetCharSequenceArrayListDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetCharSequenceArrayListDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetCharSequenceArrayList.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetCharSequenceArrayList.kt:5: Warning: Use getCharSequenceArrayListOrNull or getCharSequenceArrayListOrThrow [UseBundleGetCharSequenceArrayList]
        bundle.getCharSequenceArrayList("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetCharSequenceArrayList.kt line 5: Replace with getCharSequenceArrayListOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getCharSequenceArrayListOrNull
@@ -5 +6
-         bundle.getCharSequenceArrayList("")
+         bundle.getCharSequenceArrayListOrNull("")
Fix for src/UseBundleGetCharSequenceArrayList.kt line 5: Replace with getCharSequenceArrayListOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getCharSequenceArrayListOrThrow
@@ -5 +6
-         bundle.getCharSequenceArrayList("")
+         bundle.getCharSequenceArrayListOrThrow("")
    """.trimIndent()
}
