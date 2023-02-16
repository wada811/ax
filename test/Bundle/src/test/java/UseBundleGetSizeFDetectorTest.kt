import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetSizeFDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetSizeFDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetSizeF.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetSizeF.kt:5: Warning: Use getSizeFOrNull or getSizeFOrThrow [UseBundleGetSizeF]
        bundle.getSizeF("")
        ~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetSizeF.kt line 5: Replace with getSizeFOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getSizeFOrNull
@@ -5 +6
-         bundle.getSizeF("")
+         bundle.getSizeFOrNull("")
Fix for src/UseBundleGetSizeF.kt line 5: Replace with getSizeFOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getSizeFOrThrow
@@ -5 +6
-         bundle.getSizeF("")
+         bundle.getSizeFOrThrow("")
    """.trimIndent()
}
