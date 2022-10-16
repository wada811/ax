import android.content.Intent

class UseIntentGetFloatExtra {
    fun getFloatExtra(intent: Intent) {
        intent.getFloatExtra("", 0f)
    }
}