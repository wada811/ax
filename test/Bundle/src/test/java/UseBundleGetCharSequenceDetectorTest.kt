import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetCharSequenceDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.bundle.lint.UseBundleGetCharSequenceDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetCharSequence.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetCharSequence.kt:5: Warning: Use getCharSequenceOrNull or getCharSequenceOrThrow [UseBundleGetCharSequence]
        bundle.getCharSequence("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetCharSequence.kt line 5: Replace with getCharSequenceOrNull:
@@ -1 +1
+ import com.wada811.adx.bundle.getCharSequenceOrNull
@@ -5 +6
-         bundle.getCharSequence("")
+         bundle.getCharSequenceOrNull("")
Fix for src/UseBundleGetCharSequence.kt line 5: Replace with getCharSequenceOrThrow:
@@ -1 +1
+ import com.wada811.adx.bundle.getCharSequenceOrThrow
@@ -5 +6
-         bundle.getCharSequence("")
+         bundle.getCharSequenceOrThrow("")
    """.trimIndent()
}