import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile
import com.wada811.ax.intent.lint.UseIntentGetParcelableArrayListExtraDetector

class UseIntentGetParcelableArrayListExtraDetectorTest : DetectorTest {
    override val issue: Issue = UseIntentGetParcelableArrayListExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetParcelableArrayListExtra.kt"),
    )
    override val expectedLint: String = """
src/UseIntentGetParcelableArrayListExtra.kt:6: Warning: Use getParcelableArrayListExtraOrNull or requireParcelableArrayListExtra [UseIntentGetParcelableArrayListExtra]
        intent.getParcelableArrayListExtra<Intent>("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseIntentGetParcelableArrayListExtra.kt:8: Warning: Use getParcelableArrayListExtraOrNull or requireParcelableArrayListExtra [UseIntentGetParcelableArrayListExtra]
            intent.getParcelableArrayListExtra("", Intent::class.java)
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 2 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetParcelableArrayListExtra.kt line 6: Replace with requireParcelableArrayListExtra<Intent>(""):
@@ -6 +6
-         intent.getParcelableArrayListExtra<Intent>("")
+         intent.requireParcelableArrayListExtra<Intent>("")
Fix for src/UseIntentGetParcelableArrayListExtra.kt line 6: Replace with getParcelableArrayListExtraOrNull<Intent>(""):
@@ -6 +6
-         intent.getParcelableArrayListExtra<Intent>("")
+         intent.getParcelableArrayListExtraOrNull<Intent>("")
Fix for src/UseIntentGetParcelableArrayListExtra.kt line 8: Replace with requireParcelableArrayListExtra<Intent>(""):
@@ -8 +8
-             intent.getParcelableArrayListExtra("", Intent::class.java)
+             intent.requireParcelableArrayListExtra<Intent>("")
Fix for src/UseIntentGetParcelableArrayListExtra.kt line 8: Replace with getParcelableArrayListExtraOrNull<Intent>(""):
@@ -8 +8
-             intent.getParcelableArrayListExtra("", Intent::class.java)
+             intent.getParcelableArrayListExtraOrNull<Intent>("")
    """.trimIndent()
}
