import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetLongArrayDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.bundle.lint.UseBundleGetLongArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetLongArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetLongArray.kt:5: Warning: Use getLongArrayOrNull or getLongArrayOrThrow [UseBundleGetLongArray]
        bundle.getLongArray("")
        ~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetLongArray.kt line 5: Replace with getLongArrayOrNull:
@@ -1 +1
+ import com.wada811.adx.bundle.getLongArrayOrNull
@@ -5 +6
-         bundle.getLongArray("")
+         bundle.getLongArrayOrNull("")
Fix for src/UseBundleGetLongArray.kt line 5: Replace with getLongArrayOrThrow:
@@ -1 +1
+ import com.wada811.adx.bundle.getLongArrayOrThrow
@@ -5 +6
-         bundle.getLongArray("")
+         bundle.getLongArrayOrThrow("")
    """.trimIndent()
}