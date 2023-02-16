import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.bundle.lint.UseBundleGetSerializableDetector
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.kotlinFile

class UseBundleGetSerializableDetectorTest : DetectorTest {
    override val issue: Issue = UseBundleGetSerializableDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetSerializable.kt"),
    )
    override val expectedLint: String = """
src/UseBundleGetSerializable.kt:7: Warning: Use getSerializableOrNull or getSerializableOrThrow [UseBundleGetSerializable]
        bundle.getSerializable("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseBundleGetSerializable.kt:9: Warning: Use getSerializableOrNull or getSerializableOrThrow [UseBundleGetSerializable]
            bundle.getSerializable("", LocalDate::class.java)
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 2 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetSerializable.kt line 7: Replace with getSerializableOrThrow(""):
@@ -7 +7
-         bundle.getSerializable("")
+         bundle.getSerializableOrThrow("")
Fix for src/UseBundleGetSerializable.kt line 7: Replace with getSerializableOrNull(""):
@@ -7 +7
-         bundle.getSerializable("")
+         bundle.getSerializableOrNull("")
Fix for src/UseBundleGetSerializable.kt line 9: Replace with getSerializableOrThrow<LocalDate>(""):
@@ -9 +9
-             bundle.getSerializable("", LocalDate::class.java)
+             bundle.getSerializableOrThrow<LocalDate>("")
Fix for src/UseBundleGetSerializable.kt line 9: Replace with getSerializableOrNull<LocalDate>(""):
@@ -9 +9
-             bundle.getSerializable("", LocalDate::class.java)
+             bundle.getSerializableOrNull<LocalDate>("")
    """.trimIndent()
}
