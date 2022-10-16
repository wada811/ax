import android.content.Intent

class UseIntentGetBooleanExtra {
    fun getBooleanExtra(intent: Intent) {
        intent.getBooleanExtra("", false)
    }
}