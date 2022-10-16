import androidx.activity.result.ActivityResultLauncher

class UseActivityResultLauncherLaunch {
    fun <T> launch(launcher: ActivityResultLauncher<T>) {
        launcher.launch(null)
    }
}
