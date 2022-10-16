import android.content.Intent

class UseIntentGetCharExtra {
    fun getCharExtra(intent: Intent) {
        intent.getCharExtra("", 0.toChar())
    }
}