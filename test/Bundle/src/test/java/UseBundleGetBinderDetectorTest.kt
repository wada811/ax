import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetBinderDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.bundle.lint.UseBundleGetBinderDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetBinder.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetBinder.kt:5: Warning: Use getBinderOrNull or getBinderOrThrow [UseBundleGetBinder]
        bundle.getBinder("")
        ~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetBinder.kt line 5: Replace with getBinderOrNull:
@@ -1 +1
+ import com.wada811.adx.bundle.getBinderOrNull
@@ -5 +6
-         bundle.getBinder("")
+         bundle.getBinderOrNull("")
Fix for src/UseBundleGetBinder.kt line 5: Replace with getBinderOrThrow:
@@ -1 +1
+ import com.wada811.adx.bundle.getBinderOrThrow
@@ -5 +6
-         bundle.getBinder("")
+         bundle.getBinderOrThrow("")
    """.trimIndent()
}