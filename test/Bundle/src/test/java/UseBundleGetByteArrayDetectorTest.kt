import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetByteArrayDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.bundle.lint.UseBundleGetByteArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetByteArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetByteArray.kt:5: Warning: Use getByteArrayOrNull or getByteArrayOrThrow [UseBundleGetByteArray]
        bundle.getByteArray("")
        ~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetByteArray.kt line 5: Replace with getByteArrayOrNull:
@@ -1 +1
+ import com.wada811.adx.bundle.getByteArrayOrNull
@@ -5 +6
-         bundle.getByteArray("")
+         bundle.getByteArrayOrNull("")
Fix for src/UseBundleGetByteArray.kt line 5: Replace with getByteArrayOrThrow:
@@ -1 +1
+ import com.wada811.adx.bundle.getByteArrayOrThrow
@@ -5 +6
-         bundle.getByteArray("")
+         bundle.getByteArrayOrThrow("")
    """.trimIndent()
}