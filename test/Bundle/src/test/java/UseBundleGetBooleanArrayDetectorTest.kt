import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetBooleanArrayDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetBooleanArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetBooleanArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetBooleanArray.kt:5: Warning: Use getBooleanArrayOrNull or getBooleanArrayOrThrow [UseBundleGetBooleanArray]
        bundle.getBooleanArray("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetBooleanArray.kt line 5: Replace with getBooleanArrayOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getBooleanArrayOrNull
@@ -5 +6
-         bundle.getBooleanArray("")
+         bundle.getBooleanArrayOrNull("")
Fix for src/UseBundleGetBooleanArray.kt line 5: Replace with getBooleanArrayOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getBooleanArrayOrThrow
@@ -5 +6
-         bundle.getBooleanArray("")
+         bundle.getBooleanArrayOrThrow("")
    """.trimIndent()
}
