import android.content.Intent
import android.os.Build
import android.os.Bundle

class UseBundleGetParcelableArray {
    fun getParcelableArray(bundle: Bundle) {
        bundle.getParcelableArray("")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelableArray("", Intent::class.java)
        }
    }
}
