import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetLongDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.bundle.lint.UseBundleGetLongDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetLong.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetLong.kt:5: Warning: Use getLongOrNull or getLongOrThrow [UseBundleGetLong]
        bundle.getLong("")
        ~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetLong.kt line 5: Replace with getLongOrNull:
@@ -1 +1
+ import com.wada811.adx.bundle.getLongOrNull
@@ -5 +6
-         bundle.getLong("")
+         bundle.getLongOrNull("")
Fix for src/UseBundleGetLong.kt line 5: Replace with getLongOrThrow:
@@ -1 +1
+ import com.wada811.adx.bundle.getLongOrThrow
@@ -5 +6
-         bundle.getLong("")
+         bundle.getLongOrThrow("")
    """.trimIndent()
}