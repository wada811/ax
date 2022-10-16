import android.content.Intent
import android.os.Build
import android.os.Bundle

class UseBundleGetParcelable {
    fun getParcelable(bundle: Bundle) {
        bundle.getParcelable<Intent>("")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable("", Intent::class.java)
        }
    }
}
