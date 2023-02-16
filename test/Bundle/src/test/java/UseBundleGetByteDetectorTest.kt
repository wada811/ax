import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetByteDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetByteDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetByte.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetByte.kt:5: Warning: Use getByteOrNull or getByteOrThrow [UseBundleGetByte]
        bundle.getByte("")
        ~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetByte.kt line 5: Replace with getByteOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getByteOrNull
@@ -5 +6
-         bundle.getByte("")
+         bundle.getByteOrNull("")
Fix for src/UseBundleGetByte.kt line 5: Replace with getByteOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getByteOrThrow
@@ -5 +6
-         bundle.getByte("")
+         bundle.getByteOrThrow("")
    """.trimIndent()
}
