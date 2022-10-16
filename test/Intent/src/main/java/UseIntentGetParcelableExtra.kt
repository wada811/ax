import android.content.Intent
import android.os.Build

class UseIntentGetParcelableExtra {
    fun getParcelableExtra(intent: Intent) {
        intent.getParcelableExtra<Intent>("")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("", Intent::class.java)
        }
    }
}
