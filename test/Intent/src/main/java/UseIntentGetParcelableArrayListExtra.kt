import android.content.Intent
import android.os.Build

class UseIntentGetParcelableArrayListExtra {
    fun getParcelableArrayListExtra(intent: Intent) {
        intent.getParcelableArrayListExtra<Intent>("")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableArrayListExtra("", Intent::class.java)
        }
    }
}
