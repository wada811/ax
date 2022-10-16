import android.content.Intent
import android.os.Build

class UseIntentGetParcelableArrayExtra {
    fun getParcelableArrayExtra(intent: Intent) {
        intent.getParcelableArrayExtra("")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableArrayExtra("", Intent::class.java)
        }
    }
}
