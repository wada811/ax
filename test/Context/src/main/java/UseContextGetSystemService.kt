import android.content.Context
import android.os.Build
import android.view.WindowManager

class UseContextGetSystemService(
    private val context: Context
) {
    private val windowManager by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context.getSystemService(WindowManager::class.java)
        } else {
            error("")
        }
    }

    fun test1(context: Context) {
        val windowManager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    }

    fun test2(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val windowManager: WindowManager? = context.getSystemService(WindowManager::class.java)
        }
    }
}
