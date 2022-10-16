import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetShortDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.bundle.lint.UseBundleGetShortDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetShort.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetShort.kt:5: Warning: Use getShortOrNull or getShortOrThrow [UseBundleGetShort]
        bundle.getShort("")
        ~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetShort.kt line 5: Replace with getShortOrNull:
@@ -1 +1
+ import com.wada811.adx.bundle.getShortOrNull
@@ -5 +6
-         bundle.getShort("")
+         bundle.getShortOrNull("")
Fix for src/UseBundleGetShort.kt line 5: Replace with getShortOrThrow:
@@ -1 +1
+ import com.wada811.adx.bundle.getShortOrThrow
@@ -5 +6
-         bundle.getShort("")
+         bundle.getShortOrThrow("")
    """.trimIndent()
}