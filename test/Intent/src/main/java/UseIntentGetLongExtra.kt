import android.content.Intent

class UseIntentGetLongExtra {
    fun getLongExtra(intent: Intent) {
        intent.getLongExtra("", 0L)
    }
}