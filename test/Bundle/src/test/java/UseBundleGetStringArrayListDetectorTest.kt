import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetStringArrayListDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetStringArrayListDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetStringArrayList.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetStringArrayList.kt:5: Warning: Use getStringArrayListOrNull or getStringArrayListOrThrow [UseBundleGetStringArrayList]
        bundle.getStringArrayList("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetStringArrayList.kt line 5: Replace with getStringArrayListOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getStringArrayListOrNull
@@ -5 +6
-         bundle.getStringArrayList("")
+         bundle.getStringArrayListOrNull("")
Fix for src/UseBundleGetStringArrayList.kt line 5: Replace with getStringArrayListOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getStringArrayListOrThrow
@@ -5 +6
-         bundle.getStringArrayList("")
+         bundle.getStringArrayListOrThrow("")
    """.trimIndent()
}
