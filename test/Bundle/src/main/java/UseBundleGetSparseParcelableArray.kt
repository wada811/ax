import android.content.Intent
import android.os.Build
import android.os.Bundle

class UseBundleGetSparseParcelableArray {
    fun getSparseParcelableArray(bundle: Bundle) {
        bundle.getSparseParcelableArray<Intent>("")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getSparseParcelableArray("", Intent::class.java)
        }
    }
}
