package com.wada811.adx.context

import android.content.Context
import androidx.core.content.getSystemService

@Suppress("RemoveExplicitTypeArguments")
inline fun <reified T : Any> Context.requireSystemService(): T = requireNotNull(getSystemService<T>())
