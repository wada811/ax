import android.content.Intent
import android.os.Build
import android.os.Bundle

class UseBundleGetParcelableArrayList {
    fun getParcelableArrayList(bundle: Bundle) {
        bundle.getParcelableArrayList<Intent>("")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelableArrayList("", Intent::class.java)
        }
    }
}
