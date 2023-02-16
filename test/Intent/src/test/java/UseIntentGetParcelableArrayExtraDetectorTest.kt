import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile
import com.wada811.ax.intent.lint.UseIntentGetParcelableArrayExtraDetector

class UseIntentGetParcelableArrayExtraDetectorTest : DetectorTest {
    override val issue: Issue = UseIntentGetParcelableArrayExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetParcelableArrayExtra.kt"),
    )
    override val expectedLint: String = """
src/UseIntentGetParcelableArrayExtra.kt:6: Warning: Use getParcelableArrayExtraOrNull or requireParcelableArrayExtra [UseIntentGetParcelableArrayExtra]
        intent.getParcelableArrayExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseIntentGetParcelableArrayExtra.kt:8: Warning: Use getParcelableArrayExtraOrNull or requireParcelableArrayExtra [UseIntentGetParcelableArrayExtra]
            intent.getParcelableArrayExtra("", Intent::class.java)
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 2 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetParcelableArrayExtra.kt line 6: Replace with requireParcelableArrayExtra<Parcelable>(""):
@@ -6 +6
-         intent.getParcelableArrayExtra("")
+         intent.requireParcelableArrayExtra<Parcelable>("")
Fix for src/UseIntentGetParcelableArrayExtra.kt line 6: Replace with getParcelableArrayExtraOrNull<Parcelable>(""):
@@ -6 +6
-         intent.getParcelableArrayExtra("")
+         intent.getParcelableArrayExtraOrNull<Parcelable>("")
Fix for src/UseIntentGetParcelableArrayExtra.kt line 8: Replace with requireParcelableArrayExtra<Intent>(""):
@@ -8 +8
-             intent.getParcelableArrayExtra("", Intent::class.java)
+             intent.requireParcelableArrayExtra<Intent>("")
Fix for src/UseIntentGetParcelableArrayExtra.kt line 8: Replace with getParcelableArrayExtraOrNull<Intent>(""):
@@ -8 +8
-             intent.getParcelableArrayExtra("", Intent::class.java)
+             intent.getParcelableArrayExtraOrNull<Intent>("")
    """.trimIndent()
}
