package com.wada811.ax.core.test

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.checks.infrastructure.TestLintTask
import com.android.tools.lint.checks.infrastructure.TestMode
import com.android.tools.lint.detector.api.Issue
import org.junit.Test

@Suppress("UnstableApiUsage")
interface DetectorTest {
    val issue: Issue
    val testFiles: List<TestFile>
    val expectedLint: String
    val expectedFixDiffs: String

    @Test
    fun testLint() {
        TestLintTask.lint()
            .files(*testFiles.toTypedArray())
            .issues(issue)
            .testModes(TestMode.DEFAULT)
            .run()
            .expect(expectedLint)
    }

    @Test
    fun testFix() {
        TestLintTask.lint()
            .files(*testFiles.toTypedArray())
            .issues(issue)
            .testModes(TestMode.DEFAULT)
            .run()
            .expectFixDiffs(expectedFixDiffs)
    }
}
