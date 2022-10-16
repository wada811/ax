import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseIntentGetStringArrayListExtraDetectorTest : DetectorTest {
    override val issue: Issue = com.wada811.adx.intent.lint.UseIntentGetStringArrayListExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetStringArrayListExtra.kt")
    )
    override val expectedLint: String = """
src/UseIntentGetStringArrayListExtra.kt:5: Warning: Use getStringArrayListExtraOrNull or getStringArrayListExtraOrThrow [UseIntentGetStringArrayListExtra]
        intent.getStringArrayListExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetStringArrayListExtra.kt line 5: Replace with getStringArrayListExtraOrNull:
@@ -1 +1
+ import com.wada811.adx.intent.getStringArrayListExtraOrNull
@@ -5 +6
-         intent.getStringArrayListExtra("")
+         intent.getStringArrayListExtraOrNull("")
Fix for src/UseIntentGetStringArrayListExtra.kt line 5: Replace with getStringArrayListExtraOrThrow:
@@ -1 +1
+ import com.wada811.adx.intent.getStringArrayListExtraOrThrow
@@ -5 +6
-         intent.getStringArrayListExtra("")
+         intent.getStringArrayListExtraOrThrow("")
    """.trimIndent()
}