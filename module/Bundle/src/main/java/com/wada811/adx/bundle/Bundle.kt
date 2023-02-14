@file:Suppress("DEPRECATION", "RemoveExplicitTypeArguments", "unused")

package com.wada811.adx.bundle

import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.os.Parcelable
import android.util.Size
import android.util.SizeF
import android.util.SparseArray
import androidx.core.os.BundleCompat
import java.io.Serializable

inline fun <reified T : Any> Bundle.checkNotNullCatching(key: String, block: () -> T?): Result<T> = runCatching {
    check(containsKey(key)) { "$this has no key: $key" }
    checkNotNull(block()) { "$this, key: $key, wrong type: ${T::class.java.simpleName}, correct type: ${get(key)?.javaClass?.simpleName}" }
}

fun Bundle.getBinderCatching(key: String): Result<IBinder> = checkNotNullCatching(key) { getBinder(key) }
fun Bundle.getBinderOrNull(key: String): IBinder? = getBinderCatching(key).getOrNull()
fun Bundle.getBinderOrThrow(key: String): IBinder = getBinderCatching(key).getOrThrow()

fun Bundle.getBooleanCatching(key: String): Result<Boolean> = checkNotNullCatching(key) { getBoolean(key) }
fun Bundle.getBooleanOrNull(key: String): Boolean? = getBooleanCatching(key).getOrNull()
fun Bundle.getBooleanOrThrow(key: String): Boolean = getBooleanCatching(key).getOrThrow()
fun Bundle.getBooleanOrDefault(key: String, defaultValue: Boolean): Boolean = getBooleanCatching(key).getOrDefault(defaultValue)
fun Bundle.getBooleanOrElse(key: String, onFailure: (exception: Throwable) -> Boolean): Boolean = getBooleanCatching(key).getOrElse(onFailure)

fun Bundle.getBooleanArrayCatching(key: String): Result<BooleanArray> = checkNotNullCatching(key) { getBooleanArray(key) }
fun Bundle.getBooleanArrayOrNull(key: String): BooleanArray? = getBooleanArrayCatching(key).getOrNull()
fun Bundle.getBooleanArrayOrThrow(key: String): BooleanArray = getBooleanArrayCatching(key).getOrThrow()

fun Bundle.getBundleCatching(key: String): Result<Bundle> = checkNotNullCatching(key) { getBundle(key) }
fun Bundle.getBundleOrNull(key: String): Bundle? = getBundleCatching(key).getOrNull()
fun Bundle.getBundleOrThrow(key: String): Bundle = getBundleCatching(key).getOrThrow()

fun Bundle.getByteCatching(key: String): Result<Byte> = checkNotNullCatching(key) { getByte(key) }
fun Bundle.getByteOrNull(key: String): Byte? = getByteCatching(key).getOrNull()
fun Bundle.getByteOrThrow(key: String): Byte = getByteCatching(key).getOrThrow()
fun Bundle.getByteOrDefault(key: String, defaultValue: Byte) = getByteCatching(key).getOrDefault(defaultValue)
fun Bundle.getByteOrElse(key: String, onFailure: (exception: Throwable) -> Byte): Byte = getByteCatching(key).getOrElse(onFailure)

fun Bundle.getByteArrayCatching(key: String): Result<ByteArray> = checkNotNullCatching(key) { getByteArray(key) }
fun Bundle.getByteArrayOrNull(key: String): ByteArray? = getByteArrayCatching(key).getOrNull()
fun Bundle.getByteArrayOrThrow(key: String): ByteArray = getByteArrayCatching(key).getOrThrow()

fun Bundle.getCharCatching(key: String): Result<Char> = checkNotNullCatching(key) { getChar(key) }
fun Bundle.getCharOrThrow(key: String): Char = getCharCatching(key).getOrThrow()
fun Bundle.getCharOrNull(key: String): Char? = getCharCatching(key).getOrNull()
fun Bundle.getCharOrDefault(key: String, defaultValue: Char): Char = getCharCatching(key).getOrDefault(defaultValue)
fun Bundle.getCharOrElse(key: String, onFailure: (exception: Throwable) -> Char): Char = getCharCatching(key).getOrElse(onFailure)

fun Bundle.getCharArrayCatching(key: String): Result<CharArray> = checkNotNullCatching(key) { getCharArray(key) }
fun Bundle.getCharArrayOrNull(key: String): CharArray? = getCharArrayCatching(key).getOrNull()
fun Bundle.getCharArrayOrThrow(key: String): CharArray = getCharArrayCatching(key).getOrThrow()

fun Bundle.getCharSequenceCatching(key: String): Result<CharSequence> = checkNotNullCatching(key) { getCharSequence(key) }
fun Bundle.getCharSequenceOrNull(key: String): CharSequence? = getCharSequenceCatching(key).getOrNull()
fun Bundle.getCharSequenceOrThrow(key: String): CharSequence = getCharSequenceCatching(key).getOrThrow()
fun Bundle.getCharSequenceOrDefault(key: String, defaultValue: CharSequence): CharSequence = getCharSequenceCatching(key).getOrDefault(defaultValue)
fun Bundle.getCharSequenceOrElse(key: String, onFailure: (exception: Throwable) -> CharSequence): CharSequence = getCharSequenceCatching(key).getOrElse(onFailure)

fun Bundle.getCharSequenceArrayCatching(key: String): Result<Array<CharSequence>> = checkNotNullCatching(key) { getCharSequenceArray(key) }
fun Bundle.getCharSequenceArrayOrNull(key: String): Array<CharSequence>? = getCharSequenceArrayCatching(key).getOrNull()
fun Bundle.getCharSequenceArrayOrThrow(key: String): Array<CharSequence> = getCharSequenceArrayCatching(key).getOrThrow()

fun Bundle.getCharSequenceArrayListCatching(key: String): Result<ArrayList<CharSequence>> = checkNotNullCatching(key) { getCharSequenceArrayList(key) }
fun Bundle.getCharSequenceArrayListOrNull(key: String): ArrayList<CharSequence>? = getCharSequenceArrayListCatching(key).getOrNull()
fun Bundle.getCharSequenceArrayListOrEmpty(key: String): ArrayList<CharSequence> = getCharSequenceArrayListOrNull(key) ?: ArrayList()
fun Bundle.getCharSequenceArrayListOrThrow(key: String): ArrayList<CharSequence> = getCharSequenceArrayListCatching(key).getOrThrow()
fun Bundle.getCharSequenceListCatching(key: String): Result<List<CharSequence>> = getCharSequenceArrayListCatching(key).mapCatching { it.toList() }
fun Bundle.getCharSequenceListOrNull(key: String): List<CharSequence>? = getCharSequenceListCatching(key).getOrNull()
fun Bundle.getCharSequenceListOrEmpty(key: String): List<CharSequence> = getCharSequenceListOrNull(key) ?: emptyList()
fun Bundle.getCharSequenceListOrThrow(key: String): List<CharSequence> = getCharSequenceListCatching(key).getOrThrow()

fun Bundle.getDoubleCatching(key: String): Result<Double> = checkNotNullCatching(key) { getDouble(key) }
fun Bundle.getDoubleOrNull(key: String): Double? = getDoubleCatching(key).getOrNull()
fun Bundle.getDoubleOrThrow(key: String): Double = getDoubleCatching(key).getOrThrow()
fun Bundle.getDoubleOrDefault(key: String, defaultValue: Double): Double = getDoubleCatching(key).getOrDefault(defaultValue)
fun Bundle.getDoubleOrElse(key: String, onFailure: (exception: Throwable) -> Double): Double = getDoubleCatching(key).getOrElse(onFailure)

fun Bundle.getDoubleArrayCatching(key: String): Result<DoubleArray> = checkNotNullCatching(key) { getDoubleArray(key) }
fun Bundle.getDoubleArrayOrNull(key: String): DoubleArray? = getDoubleArrayCatching(key).getOrNull()
fun Bundle.getDoubleArrayOrThrow(key: String): DoubleArray = getDoubleArrayCatching(key).getOrThrow()

fun <T : Enum<T>> Bundle.putEnum(key: String, value: T?) = value?.let { putInt(key, it.ordinal) }
inline fun <reified T : Enum<T>> Bundle.getEnumCatching(key: String): Result<T> = checkNotNullCatching(key) {
    getIntOrThrow(key).let { ordinal ->
        requireNotNull(T::class.java.enumConstants)[ordinal]
    }
}

inline fun <reified T : Enum<T>> Bundle.getEnumOrNull(key: String): T? = getEnumCatching<T>(key).getOrNull()
inline fun <reified T : Enum<T>> Bundle.getEnumOrThrow(key: String): T = getEnumCatching<T>(key).getOrThrow()
inline fun <reified T : Enum<T>> Bundle.getEnumOrDefault(key: String, defaultValue: T): T = getEnumCatching<T>(key).getOrDefault(defaultValue)
inline fun <reified T : Enum<T>> Bundle.getEnumOrElse(key: String, onFailure: (exception: Throwable) -> T): T = getEnumCatching<T>(key).getOrElse(onFailure)

fun <T : Enum<T>> Bundle.putEnumList(key: String, value: List<T>) = putIntArray(key, value.map { it.ordinal }.toIntArray())
inline fun <reified T : Enum<T>> Bundle.getEnumListCatching(key: String): Result<List<T>> = checkNotNullCatching(key) {
    getIntArrayOrNull(key)?.let { ordinals ->
        val enumConstants = requireNotNull(T::class.java.enumConstants)
        ordinals.map { enumConstants[it] }.toList()
    }
}

inline fun <reified T : Enum<T>> Bundle.getEnumListOrNull(key: String): List<T>? = getEnumListCatching<T>(key).getOrNull()
inline fun <reified T : Enum<T>> Bundle.getEnumListOrEmpty(key: String): List<T> = getEnumListOrNull<T>(key) ?: emptyList()
inline fun <reified T : Enum<T>> Bundle.getEnumListOrThrow(key: String): List<T> = getEnumListCatching<T>(key).getOrThrow()
inline fun <reified T : Enum<T>> Bundle.getEnumListOrDefault(key: String, defaultValue: List<T>): List<T> = getEnumListCatching<T>(key).getOrDefault(defaultValue)
inline fun <reified T : Enum<T>> Bundle.getEnumListOrElse(key: String, onFailure: (exception: Throwable) -> List<T>): List<T> = getEnumListCatching<T>(key).getOrElse(onFailure)

fun Bundle.getFloatCatching(key: String): Result<Float> = checkNotNullCatching(key) { getFloat(key) }
fun Bundle.getFloatOrNull(key: String): Float? = getFloatCatching(key).getOrNull()
fun Bundle.getFloatOrThrow(key: String): Float = getFloatCatching(key).getOrThrow()
fun Bundle.getFloatOrDefault(key: String, defaultValue: Float): Float = getFloatCatching(key).getOrDefault(defaultValue)
fun Bundle.getFloatOrElse(key: String, onFailure: (exception: Throwable) -> Float): Float = getFloatCatching(key).getOrElse(onFailure)

fun Bundle.getFloatArrayCatching(key: String): Result<FloatArray> = checkNotNullCatching(key) { getFloatArray(key) }
fun Bundle.getFloatArrayOrNull(key: String): FloatArray? = getFloatArrayCatching(key).getOrNull()
fun Bundle.getFloatArrayOrThrow(key: String): FloatArray = getFloatArrayCatching(key).getOrThrow()

fun Bundle.getIntCatching(key: String): Result<Int> = checkNotNullCatching(key) { getInt(key) }
fun Bundle.getIntOrNull(key: String): Int? = getIntCatching(key).getOrNull()
fun Bundle.getIntOrThrow(key: String): Int = getIntCatching(key).getOrThrow()
fun Bundle.getIntOrDefault(key: String, defaultValue: Int): Int = getIntCatching(key).getOrDefault(defaultValue)
fun Bundle.getIntOrElse(key: String, onFailure: (exception: Throwable) -> Int): Int = getIntCatching(key).getOrElse(onFailure)

fun Bundle.getIntArrayCatching(key: String): Result<IntArray> = checkNotNullCatching(key) { getIntArray(key) }
fun Bundle.getIntArrayOrNull(key: String): IntArray? = getIntArrayCatching(key).getOrNull()
fun Bundle.getIntArrayOrThrow(key: String): IntArray = getIntArrayCatching(key).getOrThrow()

fun Bundle.getIntegerArrayListCatching(key: String): Result<ArrayList<Int>> = checkNotNullCatching(key) { getIntegerArrayList(key) }
fun Bundle.getIntegerArrayListOrNull(key: String): ArrayList<Int>? = getIntegerArrayListCatching(key).getOrNull()
fun Bundle.getIntegerArrayListOrEmpty(key: String): ArrayList<Int> = getIntegerArrayListOrNull(key) ?: ArrayList()
fun Bundle.getIntegerArrayListOrThrow(key: String): ArrayList<Int> = getIntegerArrayListCatching(key).getOrThrow()
fun Bundle.getIntegerListCatching(key: String): Result<List<Int>> = getIntegerArrayListCatching(key).mapCatching { it.toList() }
fun Bundle.getIntegerListOrNull(key: String): List<Int>? = getIntegerListCatching(key).getOrNull()
fun Bundle.getIntegerListOrEmpty(key: String): List<Int> = getIntegerListOrNull(key) ?: emptyList()
fun Bundle.getIntegerListOrThrow(key: String): List<Int> = getIntegerListCatching(key).getOrThrow()

fun Bundle.getLongCatching(key: String): Result<Long> = checkNotNullCatching(key) { getLong(key) }
fun Bundle.getLongOrNull(key: String): Long? = getLongCatching(key).getOrNull()
fun Bundle.getLongOrThrow(key: String): Long = getLongCatching(key).getOrThrow()
fun Bundle.getLongOrDefault(key: String, defaultValue: Long): Long = getLongCatching(key).getOrDefault(defaultValue)
fun Bundle.getLongOrElse(key: String, onFailure: (exception: Throwable) -> Long): Long = getLongCatching(key).getOrElse(onFailure)

fun Bundle.getLongArrayCatching(key: String): Result<LongArray> = checkNotNullCatching(key) { getLongArray(key) }
fun Bundle.getLongArrayOrNull(key: String): LongArray? = getLongArrayCatching(key).getOrNull()
fun Bundle.getLongArrayOrThrow(key: String): LongArray = getLongArrayCatching(key).getOrThrow()


@Deprecated(message = "getParcelableCompat is hidden", replaceWith = ReplaceWith("this.getParcelableOrNull(key)"), level = DeprecationLevel.WARNING)
inline fun <reified T : Parcelable> Bundle.getParcelableCompat(key: String): T? = BundleCompat.getParcelable(this, key, T::class.java)
inline fun <reified T : Parcelable> Bundle.getParcelableCatching(key: String): Result<T> = checkNotNullCatching(key) { getParcelableCompat(key) }
inline fun <reified T : Parcelable> Bundle.getParcelableOrNull(key: String): T? = getParcelableCatching<T>(key).getOrNull()
inline fun <reified T : Parcelable> Bundle.getParcelableOrThrow(key: String): T = getParcelableCatching<T>(key).getOrThrow()

@Suppress("UNCHECKED_CAST")
@Deprecated(message = "getParcelableArrayCompat is hidden", replaceWith = ReplaceWith("this.getParcelableArrayOrNull(key)"), level = DeprecationLevel.WARNING)
inline fun <reified T : Parcelable> Bundle.getParcelableArrayCompat(key: String): Array<T>? = BundleCompat.getParcelableArray(this, key, T::class.java) as? Array<T>
inline fun <reified T : Parcelable> Bundle.getParcelableArrayCatching(key: String): Result<Array<T>> = checkNotNullCatching(key) { getParcelableArrayCompat(key) }
inline fun <reified T : Parcelable> Bundle.getParcelableArrayOrNull(key: String): Array<T>? = getParcelableArrayCatching<T>(key).getOrNull()
inline fun <reified T : Parcelable> Bundle.getParcelableArrayOrThrow(key: String): Array<T> = getParcelableArrayCatching<T>(key).getOrThrow()

@Deprecated(message = "getParcelableArrayListCompat is hidden", replaceWith = ReplaceWith("this.getParcelableArrayListOrNull(key)"), level = DeprecationLevel.WARNING)
inline fun <reified T : Parcelable> Bundle.getParcelableArrayListCompat(key: String): ArrayList<T>? = BundleCompat.getParcelableArrayList(this, key, T::class.java)
inline fun <reified T : Parcelable> Bundle.getParcelableArrayListCatching(key: String): Result<ArrayList<T>> = checkNotNullCatching(key) { getParcelableArrayListCompat(key) }
inline fun <reified T : Parcelable> Bundle.getParcelableArrayListOrNull(key: String): ArrayList<T>? = getParcelableArrayListCatching<T>(key).getOrNull()
inline fun <reified T : Parcelable> Bundle.getParcelableArrayListOrEmpty(key: String): ArrayList<T> = getParcelableArrayListOrNull<T>(key) ?: ArrayList()
inline fun <reified T : Parcelable> Bundle.getParcelableArrayListOrThrow(key: String): ArrayList<T> = getParcelableArrayListCatching<T>(key).getOrThrow()
inline fun <reified T : Parcelable> Bundle.getParcelableListCatching(key: String): Result<List<T>> = getParcelableArrayListCatching<T>(key).mapCatching { it.toList() }
inline fun <reified T : Parcelable> Bundle.getParcelableListOrNull(key: String): List<T>? = getParcelableListCatching<T>(key).getOrNull()
inline fun <reified T : Parcelable> Bundle.getParcelableListOrEmpty(key: String): List<T> = getParcelableListOrNull<T>(key) ?: emptyList()
inline fun <reified T : Parcelable> Bundle.getParcelableListOrThrow(key: String): List<T> = getParcelableListCatching<T>(key).getOrThrow()

@Deprecated(message = "getSerializableCompat is hidden", replaceWith = ReplaceWith("this.getSerializableOrNull(key)"), level = DeprecationLevel.WARNING)
inline fun <reified T : Serializable> Bundle.getSerializableCompat(key: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getSerializable(key, T::class.java)
    } else {
        getSerializable(key) as? T
    }
}

inline fun <reified T : Serializable> Bundle.getSerializableCatching(key: String): Result<T> = checkNotNullCatching(key) { getSerializableCompat(key) }
inline fun <reified T : Serializable> Bundle.getSerializableOrNull(key: String): T? = getSerializableCatching<T>(key).getOrNull()
inline fun <reified T : Serializable> Bundle.getSerializableOrThrow(key: String): T = getSerializableCatching<T>(key).getOrThrow()

fun Bundle.getShortCatching(key: String): Result<Short> = checkNotNullCatching(key) { getShort(key) }
fun Bundle.getShortOrNull(key: String): Short? = getShortCatching(key).getOrNull()
fun Bundle.getShortOrThrow(key: String): Short = getShortCatching(key).getOrThrow()

fun Bundle.getShortArrayCatching(key: String): Result<ShortArray> = checkNotNullCatching(key) { getShortArray(key) }
fun Bundle.getShortArrayOrNull(key: String): ShortArray? = getShortArrayCatching(key).getOrNull()
fun Bundle.getShortArrayOrThrow(key: String): ShortArray = getShortArrayCatching(key).getOrThrow()

fun Bundle.getSizeCatching(key: String): Result<Size> = checkNotNullCatching(key) { getSize(key) }
fun Bundle.getSizeOrNull(key: String): Size? = getSizeCatching(key).getOrNull()
fun Bundle.getSizeOrThrow(key: String): Size = getSizeCatching(key).getOrThrow()

fun Bundle.getSizeFCatching(key: String): Result<SizeF> = checkNotNullCatching(key) { getSizeF(key) }
fun Bundle.getSizeFOrNull(key: String): SizeF? = getSizeFCatching(key).getOrNull()
fun Bundle.getSizeFOrThrow(key: String): SizeF = getSizeFCatching(key).getOrThrow()

@Deprecated(message = "getSerializableCompat is hidden", replaceWith = ReplaceWith("this.getSerializableOrNull(key)"), level = DeprecationLevel.WARNING)
inline fun <reified T : Parcelable> Bundle.getSparseParcelableArrayCompat(key: String): SparseArray<T>? = BundleCompat.getSparseParcelableArray(this, key, T::class.java)
inline fun <reified T : Parcelable> Bundle.getSparseParcelableArrayCatching(key: String): Result<SparseArray<T>> = checkNotNullCatching(key) { getSparseParcelableArrayCompat(key) }
inline fun <reified T : Parcelable> Bundle.getSparseParcelableArrayOrNull(key: String): SparseArray<T>? = getSparseParcelableArrayCatching<T>(key).getOrNull()
inline fun <reified T : Parcelable> Bundle.getSparseParcelableArrayOrThrow(key: String): SparseArray<T> = getSparseParcelableArrayCatching<T>(key).getOrThrow()

fun Bundle.getStringCatching(key: String): Result<String> = checkNotNullCatching(key) { getString(key) }
fun Bundle.getStringOrNull(key: String): String? = getStringCatching(key).getOrNull()
fun Bundle.getStringOrThrow(key: String): String = getStringCatching(key).getOrThrow()
fun Bundle.getStringOrDefault(key: String, defaultValue: String): String = getStringCatching(key).getOrDefault(defaultValue)
fun Bundle.getStringOrElse(key: String, onFailure: (Throwable) -> String): String = getStringCatching(key).getOrElse(onFailure)

fun Bundle.getStringArrayCatching(key: String): Result<Array<String>> = checkNotNullCatching(key) { getStringArray(key) }
fun Bundle.getStringArrayOrNull(key: String): Array<String>? = getStringArrayCatching(key).getOrNull()
fun Bundle.getStringArrayOrThrow(key: String): Array<String> = getStringArrayCatching(key).getOrThrow()

fun Bundle.getStringArrayListCatching(key: String): Result<ArrayList<String>> = checkNotNullCatching(key) { getStringArrayList(key) }
fun Bundle.getStringArrayListOrNull(key: String): ArrayList<String>? = getStringArrayListCatching(key).getOrNull()
fun Bundle.getStringArrayListOrEmpty(key: String): ArrayList<String> = getStringArrayListOrNull(key) ?: ArrayList()
fun Bundle.getStringArrayListOrThrow(key: String): ArrayList<String> = getStringArrayListCatching(key).getOrThrow()
fun Bundle.getStringListCatching(key: String): Result<List<String>> = getStringArrayListCatching(key).mapCatching { it.toList() }
fun Bundle.getStringListOrNull(key: String): List<String>? = getStringListCatching(key).getOrNull()
fun Bundle.getStringListOrEmpty(key: String): List<String> = getStringListOrNull(key) ?: emptyList()
fun Bundle.getStringListOrThrow(key: String): List<String> = getStringListCatching(key).getOrThrow()
