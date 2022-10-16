import android.content.Intent

class UseIntentGetByteExtra {
    fun getByteExtra(intent: Intent) {
        intent.getByteExtra("", 0)
    }
}