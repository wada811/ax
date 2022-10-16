import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile
import com.wada811.adx.intent.lint.UseIntentGetParcelableExtraDetector

class UseIntentGetParcelableExtraDetectorTest : DetectorTest {
    override val issue: Issue = UseIntentGetParcelableExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetParcelableExtra.kt"),
    )
    override val expectedLint: String = """
src/UseIntentGetParcelableExtra.kt:6: Warning: Use getParcelableExtraOrNull or requireParcelableExtra [UseIntentGetParcelableExtra]
        intent.getParcelableExtra<Intent>("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseIntentGetParcelableExtra.kt:8: Warning: Use getParcelableExtraOrNull or requireParcelableExtra [UseIntentGetParcelableExtra]
            intent.getParcelableExtra("", Intent::class.java)
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 2 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetParcelableExtra.kt line 6: Replace with requireParcelableExtra<Intent>(""):
@@ -6 +6
-         intent.getParcelableExtra<Intent>("")
+         intent.requireParcelableExtra<Intent>("")
Fix for src/UseIntentGetParcelableExtra.kt line 6: Replace with getParcelableExtraOrNull<Intent>(""):
@@ -6 +6
-         intent.getParcelableExtra<Intent>("")
+         intent.getParcelableExtraOrNull<Intent>("")
Fix for src/UseIntentGetParcelableExtra.kt line 8: Replace with requireParcelableExtra<Intent>(""):
@@ -8 +8
-             intent.getParcelableExtra("", Intent::class.java)
+             intent.requireParcelableExtra<Intent>("")
Fix for src/UseIntentGetParcelableExtra.kt line 8: Replace with getParcelableExtraOrNull<Intent>(""):
@@ -8 +8
-             intent.getParcelableExtra("", Intent::class.java)
+             intent.getParcelableExtraOrNull<Intent>("")
    """.trimIndent()
}
