import android.content.Intent

class UseIntentGetIntExtra {
    fun getIntExtra(intent: Intent) {
        intent.getIntExtra("", 0)
    }
}