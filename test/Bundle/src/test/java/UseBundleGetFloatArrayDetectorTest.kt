import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetFloatArrayDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.bundle.lint.UseBundleGetFloatArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetFloatArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetFloatArray.kt:5: Warning: Use getFloatArrayOrNull or getFloatArrayOrThrow [UseBundleGetFloatArray]
        bundle.getFloatArray("")
        ~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetFloatArray.kt line 5: Replace with getFloatArrayOrNull:
@@ -1 +1
+ import com.wada811.adx.bundle.getFloatArrayOrNull
@@ -5 +6
-         bundle.getFloatArray("")
+         bundle.getFloatArrayOrNull("")
Fix for src/UseBundleGetFloatArray.kt line 5: Replace with getFloatArrayOrThrow:
@@ -1 +1
+ import com.wada811.adx.bundle.getFloatArrayOrThrow
@@ -5 +6
-         bundle.getFloatArray("")
+         bundle.getFloatArrayOrThrow("")
    """.trimIndent()
}