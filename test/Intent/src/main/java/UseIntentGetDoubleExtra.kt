import android.content.Intent

class UseIntentGetDoubleExtra {
    fun getDoubleExtra(intent: Intent) {
        intent.getDoubleExtra("", 0.0)
    }
}