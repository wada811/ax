import android.content.Intent
import android.os.Build
import java.time.LocalDate

class UseIntentGetSerializableExtra {
    fun getSerializableExtra(intent: Intent) {
        intent.getSerializableExtra("")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("", LocalDate::class.java)
        }
    }
}
