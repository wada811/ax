package com.wada811.ax.activityresultlauncher

import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityOptionsCompat

@JvmOverloads
fun <T> ActivityResultLauncher<T>.launchCatching(
    input: T?,
    options: ActivityOptionsCompat? = null
): Result<Unit> = runCatching {
    launch(input, options)
}

