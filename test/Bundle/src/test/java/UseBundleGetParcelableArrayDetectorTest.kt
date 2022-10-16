import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.bundle.lint.UseBundleGetParcelableArrayDetector
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseBundleGetParcelableArrayDetectorTest : DetectorTest {
    override val issue: Issue = UseBundleGetParcelableArrayDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        kotlinFile("src/main/java/UseBundleGetParcelableArray.kt")
    )
    override val expectedLint: String = """
src/UseBundleGetParcelableArray.kt:7: Warning: Use getParcelableArrayOrNull or getParcelableArrayOrThrow [UseBundleGetParcelableArray]
        bundle.getParcelableArray("")
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseBundleGetParcelableArray.kt:9: Warning: Use getParcelableArrayOrNull or getParcelableArrayOrThrow [UseBundleGetParcelableArray]
            bundle.getParcelableArray("", Intent::class.java)
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 2 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseBundleGetParcelableArray.kt line 7: Replace with getParcelableArrayOrThrow<Parcelable>(""):
@@ -7 +7
-         bundle.getParcelableArray("")
+         bundle.getParcelableArrayOrThrow<Parcelable>("")
Fix for src/UseBundleGetParcelableArray.kt line 7: Replace with getParcelableArrayOrNull<Parcelable>(""):
@@ -7 +7
-         bundle.getParcelableArray("")
+         bundle.getParcelableArrayOrNull<Parcelable>("")
Fix for src/UseBundleGetParcelableArray.kt line 9: Replace with getParcelableArrayOrThrow<Intent>(""):
@@ -9 +9
-             bundle.getParcelableArray("", Intent::class.java)
+             bundle.getParcelableArrayOrThrow<Intent>("")
Fix for src/UseBundleGetParcelableArray.kt line 9: Replace with getParcelableArrayOrNull<Intent>(""):
@@ -9 +9
-             bundle.getParcelableArray("", Intent::class.java)
+             bundle.getParcelableArrayOrNull<Intent>("")
    """.trimIndent()
}


