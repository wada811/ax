import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.bundle.lint.UseBundleGetParcelableDetector
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetParcelableDetectorTest : DetectorTest {
    override val issue: Issue = UseBundleGetParcelableDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetParcelable.kt"),
    )
    override val expectedLint: String = """
src/UseBundleGetParcelable.kt:7: Warning: Use getParcelableOrNull or getParcelableOrThrow [UseBundleGetParcelable]
        bundle.getParcelable<Intent>("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseBundleGetParcelable.kt:9: Warning: Use getParcelableOrNull or getParcelableOrThrow [UseBundleGetParcelable]
            bundle.getParcelable("", Intent::class.java)
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 2 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetParcelable.kt line 7: Replace with getParcelableOrThrow<Intent>(""):
@@ -7 +7
-         bundle.getParcelable<Intent>("")
+         bundle.getParcelableOrThrow<Intent>("")
Fix for src/UseBundleGetParcelable.kt line 7: Replace with getParcelableOrNull<Intent>(""):
@@ -7 +7
-         bundle.getParcelable<Intent>("")
+         bundle.getParcelableOrNull<Intent>("")
Fix for src/UseBundleGetParcelable.kt line 9: Replace with getParcelableOrThrow<Intent>(""):
@@ -9 +9
-             bundle.getParcelable("", Intent::class.java)
+             bundle.getParcelableOrThrow<Intent>("")
Fix for src/UseBundleGetParcelable.kt line 9: Replace with getParcelableOrNull<Intent>(""):
@@ -9 +9
-             bundle.getParcelable("", Intent::class.java)
+             bundle.getParcelableOrNull<Intent>("")
    """.trimIndent()
}
