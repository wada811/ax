import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.bundle.lint.UseBundleGetSparseParcelableArrayDetector
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetSparseParcelableArrayDetectorTest : DetectorTest {
    override val issue: Issue = UseBundleGetSparseParcelableArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetSparseParcelableArray.kt"),
    )
    override val expectedLint: String = """
src/UseBundleGetSparseParcelableArray.kt:7: Warning: Use getSparseParcelableArrayOrNull or getSparseParcelableArrayOrThrow [UseBundleGetSparseParcelableArray]
        bundle.getSparseParcelableArray<Intent>("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseBundleGetSparseParcelableArray.kt:9: Warning: Use getSparseParcelableArrayOrNull or getSparseParcelableArrayOrThrow [UseBundleGetSparseParcelableArray]
            bundle.getSparseParcelableArray("", Intent::class.java)
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 2 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetSparseParcelableArray.kt line 7: Replace with getSparseParcelableArrayOrThrow<Intent>(""):
@@ -7 +7
-         bundle.getSparseParcelableArray<Intent>("")
+         bundle.getSparseParcelableArrayOrThrow<Intent>("")
Fix for src/UseBundleGetSparseParcelableArray.kt line 7: Replace with getSparseParcelableArrayOrNull<Intent>(""):
@@ -7 +7
-         bundle.getSparseParcelableArray<Intent>("")
+         bundle.getSparseParcelableArrayOrNull<Intent>("")
Fix for src/UseBundleGetSparseParcelableArray.kt line 9: Replace with getSparseParcelableArrayOrThrow<Intent>(""):
@@ -9 +9
-             bundle.getSparseParcelableArray("", Intent::class.java)
+             bundle.getSparseParcelableArrayOrThrow<Intent>("")
Fix for src/UseBundleGetSparseParcelableArray.kt line 9: Replace with getSparseParcelableArrayOrNull<Intent>(""):
@@ -9 +9
-             bundle.getSparseParcelableArray("", Intent::class.java)
+             bundle.getSparseParcelableArrayOrNull<Intent>("")
    """.trimIndent()
}
