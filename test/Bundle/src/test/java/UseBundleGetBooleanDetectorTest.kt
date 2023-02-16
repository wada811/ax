import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetBooleanDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.ax.bundle.lint.UseBundleGetBooleanDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetBoolean.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetBoolean.kt:5: Warning: Use getBooleanOrNull or getBooleanOrThrow [UseBundleGetBoolean]
        bundle.getBoolean("")
        ~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetBoolean.kt line 5: Replace with getBooleanOrNull:
@@ -1 +1
+ import com.wada811.ax.bundle.getBooleanOrNull
@@ -5 +6
-         bundle.getBoolean("")
+         bundle.getBooleanOrNull("")
Fix for src/UseBundleGetBoolean.kt line 5: Replace with getBooleanOrThrow:
@@ -1 +1
+ import com.wada811.ax.bundle.getBooleanOrThrow
@@ -5 +6
-         bundle.getBoolean("")
+         bundle.getBooleanOrThrow("")
    """.trimIndent()
}
