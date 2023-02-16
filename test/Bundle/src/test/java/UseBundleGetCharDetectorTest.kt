import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetCharDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetCharDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetChar.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetChar.kt:5: Warning: Use getCharOrNull or getCharOrThrow [UseBundleGetChar]
        bundle.getChar("")
        ~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetChar.kt line 5: Replace with getCharOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getCharOrNull
@@ -5 +6
-         bundle.getChar("")
+         bundle.getCharOrNull("")
Fix for src/UseBundleGetChar.kt line 5: Replace with getCharOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getCharOrThrow
@@ -5 +6
-         bundle.getChar("")
+         bundle.getCharOrThrow("")
    """.trimIndent()
}
