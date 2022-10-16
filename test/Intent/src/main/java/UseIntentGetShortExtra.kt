import android.content.Intent

class UseIntentGetShortExtra {
    fun getShortExtra(intent: Intent) {
        intent.getShortExtra("", 0)
    }
}