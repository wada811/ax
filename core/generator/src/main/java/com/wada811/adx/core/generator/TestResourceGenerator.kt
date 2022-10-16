package com.wada811.adx.core.generator

import java.io.File

object TestResourceGenerator {
    fun Params.generate() {
        File("test/$upperClassName/src/main/java/Use$upperClassMethodName.kt")
            .writeText(
                """
import $className

class Use$upperClassMethodName {
    fun $applicableMethodName($lowerClassName: $upperClassName) {
        $lowerClassName.$applicableMethodName($methodParamsText)
    }
}
            """.trimIndent()
            )
    }
}
