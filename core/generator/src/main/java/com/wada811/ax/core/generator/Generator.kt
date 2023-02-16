package com.wada811.ax.core.generator

object Generator {
    @JvmStatic
    fun main(vararg args: String) {
        Params.values().forEach {
            with(DetectorGenerator) {
                it.generate()
            }
            with(TestResourceGenerator) {
                it.generate()
            }
            with(TestSourceGenerator) {
                it.generate()
            }
        }
    }
}
