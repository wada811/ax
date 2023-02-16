import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile
import com.wada811.ax.intent.lint.UseIntentGetSerializableExtraDetector

class UseIntentGetSerializableExtraDetectorTest : DetectorTest {
    override val issue: Issue = UseIntentGetSerializableExtraDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseIntentGetSerializableExtra.kt"),
    )
    override val expectedLint: String = """
src/UseIntentGetSerializableExtra.kt:7: Warning: Use getSerializableExtraOrNull or requireSerializableExtra [UseIntentGetSerializableExtra]
        intent.getSerializableExtra("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseIntentGetSerializableExtra.kt:9: Warning: Use getSerializableExtraOrNull or requireSerializableExtra [UseIntentGetSerializableExtra]
            intent.getSerializableExtra("", LocalDate::class.java)
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 2 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseIntentGetSerializableExtra.kt line 7: Replace with requireSerializableExtra(""):
@@ -7 +7
-         intent.getSerializableExtra("")
+         intent.requireSerializableExtra("")
Fix for src/UseIntentGetSerializableExtra.kt line 7: Replace with getSerializableExtraOrNull(""):
@@ -7 +7
-         intent.getSerializableExtra("")
+         intent.getSerializableExtraOrNull("")
Fix for src/UseIntentGetSerializableExtra.kt line 9: Replace with requireSerializableExtra<LocalDate>(""):
@@ -9 +9
-             intent.getSerializableExtra("", LocalDate::class.java)
+             intent.requireSerializableExtra<LocalDate>("")
Fix for src/UseIntentGetSerializableExtra.kt line 9: Replace with getSerializableExtraOrNull<LocalDate>(""):
@@ -9 +9
-             intent.getSerializableExtra("", LocalDate::class.java)
+             intent.getSerializableExtraOrNull<LocalDate>("")
    """.trimIndent()
}
