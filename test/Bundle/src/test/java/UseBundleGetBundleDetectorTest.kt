import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetBundleDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetBundleDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetBundle.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetBundle.kt:5: Warning: Use getBundleOrNull or getBundleOrThrow [UseBundleGetBundle]
        bundle.getBundle("")
        ~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetBundle.kt line 5: Replace with getBundleOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getBundleOrNull
@@ -5 +6
-         bundle.getBundle("")
+         bundle.getBundleOrNull("")
Fix for src/UseBundleGetBundle.kt line 5: Replace with getBundleOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getBundleOrThrow
@@ -5 +6
-         bundle.getBundle("")
+         bundle.getBundleOrThrow("")
    """.trimIndent()
}
