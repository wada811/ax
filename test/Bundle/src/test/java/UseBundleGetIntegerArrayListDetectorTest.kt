import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetIntegerArrayListDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.bundle.lint.UseBundleGetIntegerArrayListDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetIntegerArrayList.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetIntegerArrayList.kt:5: Warning: Use getIntegerArrayListOrNull or getIntegerArrayListOrThrow [UseBundleGetIntegerArrayList]
        bundle.getIntegerArrayList("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetIntegerArrayList.kt line 5: Replace with getIntegerArrayListOrNull:
@@ -1 +1
+ import com.wada811.adx.bundle.getIntegerArrayListOrNull
@@ -5 +6
-         bundle.getIntegerArrayList("")
+         bundle.getIntegerArrayListOrNull("")
Fix for src/UseBundleGetIntegerArrayList.kt line 5: Replace with getIntegerArrayListOrThrow:
@@ -1 +1
+ import com.wada811.adx.bundle.getIntegerArrayListOrThrow
@@ -5 +6
-         bundle.getIntegerArrayList("")
+         bundle.getIntegerArrayListOrThrow("")
    """.trimIndent()
}