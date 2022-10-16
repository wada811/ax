import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetStringArrayDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.bundle.lint.UseBundleGetStringArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetStringArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetStringArray.kt:5: Warning: Use getStringArrayOrNull or getStringArrayOrThrow [UseBundleGetStringArray]
        bundle.getStringArray("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetStringArray.kt line 5: Replace with getStringArrayOrNull:
@@ -1 +1
+ import com.wada811.adx.bundle.getStringArrayOrNull
@@ -5 +6
-         bundle.getStringArray("")
+         bundle.getStringArrayOrNull("")
Fix for src/UseBundleGetStringArray.kt line 5: Replace with getStringArrayOrThrow:
@@ -1 +1
+ import com.wada811.adx.bundle.getStringArrayOrThrow
@@ -5 +6
-         bundle.getStringArray("")
+         bundle.getStringArrayOrThrow("")
    """.trimIndent()
}