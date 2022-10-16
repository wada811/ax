import android.os.Build
import android.os.Bundle
import java.time.LocalDate

class UseBundleGetSerializable {
    fun getSerializable(bundle: Bundle) {
        bundle.getSerializable("")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getSerializable("", LocalDate::class.java)
        }
    }
}
