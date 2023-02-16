package com.wada811.ax.activityresultlauncher.test

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.detector.api.Issue
import com.wada811.ax.activityresultlauncher.lint.UseActivityResultLauncherLaunchDetector
import com.wada811.ax.core.test.DetectorTest
import com.wada811.ax.core.test.javaFile
import com.wada811.ax.core.test.kotlinFile

class UseActivityResultLauncherLaunchDetectorTest : DetectorTest {
    override val issue: Issue = UseActivityResultLauncherLaunchDetector.ISSUE
    override val testFiles: List<TestFile> = listOf(
        javaFile("src/main/java/androidx/activity/result/ActivityResultLauncher.java"),
        kotlinFile("src/main/java/UseActivityResultLauncherLaunch.kt"),
    )
    override val expectedLint: String = """
src/UseActivityResultLauncherLaunch.kt:5: Warning: Use ActivityResultLauncher#launchCatching [UseActivityResultLauncherLaunch]
        launcher.launch(null)
        ~~~~~~~~~~~~~~~~~~~~~
0 errors, 1 warnings
    """.trimIndent()
    override val expectedFixDiffs: String = """
Autofix for src/UseActivityResultLauncherLaunch.kt line 5: Replace with launchCatching(null):
@@ -1 +1
+ import com.wada811.ax.androidx.launchCatching
@@ -5 +6
-         launcher.launch(null)
+         launcher.launchCatching(null)
    """.trimIndent()
}
