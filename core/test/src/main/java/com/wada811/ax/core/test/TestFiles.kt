package com.wada811.ax.core.test

import com.android.tools.lint.checks.infrastructure.TestFile
import com.android.tools.lint.checks.infrastructure.TestFiles
import java.io.File

fun javaFile(filePath: String): TestFile = TestFiles.java(File(filePath).readText()).indented()
fun kotlinFile(filePath: String): TestFile = TestFiles.kotlin(File(filePath).readText()).indented()
fun javaSource(source: String): TestFile = TestFiles.java(source).indented()
fun kotlinSource(source: String): TestFile = TestFiles.kotlin(source).indented()
