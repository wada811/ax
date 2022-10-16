import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetSizeDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.bundle.lint.UseBundleGetSizeDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetSize.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetSize.kt:5: Warning: Use getSizeOrNull or getSizeOrThrow [UseBundleGetSize]
        bundle.getSize("")
        ~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetSize.kt line 5: Replace with getSizeOrNull:
@@ -1 +1
+ import com.wada811.adx.bundle.getSizeOrNull
@@ -5 +6
-         bundle.getSize("")
+         bundle.getSizeOrNull("")
Fix for src/UseBundleGetSize.kt line 5: Replace with getSizeOrThrow:
@@ -1 +1
+ import com.wada811.adx.bundle.getSizeOrThrow
@@ -5 +6
-         bundle.getSize("")
+         bundle.getSizeOrThrow("")
    """.trimIndent()
}