import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.bundle.lint.UseBundleGetParcelableArrayListDetector
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetParcelableArrayListDetectorTest : DetectorTest {
    override val issue: Issue = UseBundleGetParcelableArrayListDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetParcelableArrayList.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetParcelableArrayList.kt:7: Warning: Use getParcelableArrayListOrNull or getParcelableArrayListOrThrow [UseBundleGetParcelableArrayList]
        bundle.getParcelableArrayList<Intent>("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseBundleGetParcelableArrayList.kt:9: Warning: Use getParcelableArrayListOrNull or getParcelableArrayListOrThrow [UseBundleGetParcelableArrayList]
            bundle.getParcelableArrayList("", Intent::class.java)
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 2 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetParcelableArrayList.kt line 7: Replace with getParcelableArrayListOrThrow<Intent>(""):
@@ -7 +7
-         bundle.getParcelableArrayList<Intent>("")
+         bundle.getParcelableArrayListOrThrow<Intent>("")
Fix for src/UseBundleGetParcelableArrayList.kt line 7: Replace with getParcelableArrayListOrNull<Intent>(""):
@@ -7 +7
-         bundle.getParcelableArrayList<Intent>("")
+         bundle.getParcelableArrayListOrNull<Intent>("")
Fix for src/UseBundleGetParcelableArrayList.kt line 9: Replace with getParcelableArrayListOrThrow<Intent>(""):
@@ -9 +9
-             bundle.getParcelableArrayList("", Intent::class.java)
+             bundle.getParcelableArrayListOrThrow<Intent>("")
Fix for src/UseBundleGetParcelableArrayList.kt line 9: Replace with getParcelableArrayListOrNull<Intent>(""):
@@ -9 +9
-             bundle.getParcelableArrayList("", Intent::class.java)
+             bundle.getParcelableArrayListOrNull<Intent>("")
    """.trimIndent()
}
