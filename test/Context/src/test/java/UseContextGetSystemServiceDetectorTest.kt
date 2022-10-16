import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.adx.context.lint.UseContextGetSystemServiceDetector
import com.wada811.adx.core.test.DetectorTest
import com.wada811.adx.core.test.kotlinFile

class UseContextGetSystemServiceDetectorTest : DetectorTest {
    override val issue: Issue = UseContextGetSystemServiceDetector.ISSUE
    override val testFiles: List<TestFile> =
        listOf(
            kotlinFile("src/main/java/UseContextGetSystemService.kt")
        )
    override val expectedLint: String = """
src/UseContextGetSystemService.kt:10: Warning: Use getSystemService<T>() or requireSystemService<T>() [UseUnsafeNullableGetSystemService]
            context.getSystemService(WindowManager::class.java)
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseContextGetSystemService.kt:17: Warning: Use getSystemService<T>() or requireSystemService<T>() [UseUnsafeNullableGetSystemService]
        val windowManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
                                           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
src/UseContextGetSystemService.kt:22: Warning: Use getSystemService<T>() or requireSystemService<T>() [UseUnsafeNullableGetSystemService]
            val windowManager: WindowManager? = context.getSystemService(WindowManager::class.java)
                                                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
0 errors, 3 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Fix for src/UseContextGetSystemService.kt line 10: Replace with context.requireSystemService<WindowManager>():
@@ -10 +10
-             context.getSystemService(WindowManager::class.java)
+             context.requireSystemService<WindowManager>()
Fix for src/UseContextGetSystemService.kt line 10: Replace with context.getSystemService<WindowManager>():
@@ -10 +10
-             context.getSystemService(WindowManager::class.java)
+             context.getSystemService<WindowManager>()
Fix for src/UseContextGetSystemService.kt line 17: Replace with context.requireSystemService<WindowManager>():
@@ -17 +17
-         val windowManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
+         val windowManager: WindowManager = context.requireSystemService<WindowManager>()
Fix for src/UseContextGetSystemService.kt line 17: Replace with context.getSystemService<WindowManager>():
@@ -17 +17
-         val windowManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
+         val windowManager: WindowManager = context.getSystemService<WindowManager>()
Fix for src/UseContextGetSystemService.kt line 22: Replace with context.requireSystemService<WindowManager>():
@@ -22 +22
-             val windowManager: WindowManager? = context.getSystemService(WindowManager::class.java)
+             val windowManager: WindowManager? = context.requireSystemService<WindowManager>()
Fix for src/UseContextGetSystemService.kt line 22: Replace with context.getSystemService<WindowManager>():
@@ -22 +22
-             val windowManager: WindowManager? = context.getSystemService(WindowManager::class.java)
+             val windowManager: WindowManager? = context.getSystemService<WindowManager>()
    """.trimIndent()
}
