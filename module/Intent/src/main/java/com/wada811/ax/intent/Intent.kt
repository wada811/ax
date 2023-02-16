@file:Suppress("DEPRECATION", "RemoveExplicitTypeArguments", "unused")

package com.wada811.ax.intent

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.core.content.IntentCompat
import java.io.Serializable

inline fun <reified T : Any> Intent.checkNotNullCatching(key: String, block: () -> T?): Result<T> = runCatching {
    check(extras?.containsKey(key) == true) { "$this has no key: $key" }
    checkNotNull(block()) { "$this, key: $key, wrong type: ${T::class.java.simpleName}, correct type: ${extras?.get(key)?.javaClass?.simpleName}" }
}

fun Intent.getBooleanExtraCatching(key: String): Result<Boolean> = checkNotNullCatching(key) { getBooleanExtra(key, false) }
fun Intent.getBooleanExtraOrNull(key: String): Boolean? = getBooleanExtraCatching(key).getOrNull()
fun Intent.getBooleanExtraOrThrow(key: String): Boolean = getBooleanExtraCatching(key).getOrThrow()
fun Intent.getBooleanExtraOrDefault(key: String, defaultValue: Boolean): Boolean = getBooleanExtraCatching(key).getOrDefault(defaultValue)

fun Intent.getBooleanArrayExtraCatching(key: String): Result<BooleanArray> = checkNotNullCatching(key) { getBooleanArrayExtra(key) }
fun Intent.getBooleanArrayExtraOrNull(key: String): BooleanArray? = getBooleanArrayExtraCatching(key).getOrNull()
fun Intent.getBooleanArrayExtraOrThrow(key: String): BooleanArray = getBooleanArrayExtraCatching(key).getOrThrow()

fun Intent.getBundleExtraCatching(key: String): Result<Bundle> = checkNotNullCatching(key) { getBundleExtra(key) }
fun Intent.getBundleExtraOrNull(key: String): Bundle? = getBundleExtraCatching(key).getOrNull()
fun Intent.getBundleExtraOrThrow(key: String): Bundle = getBundleExtraCatching(key).getOrThrow()

fun Intent.getByteExtraCatching(key: String): Result<Byte> = checkNotNullCatching(key) { getByteExtra(key, 0) }
fun Intent.getByteExtraOrNull(key: String): Byte? = getByteExtraCatching(key).getOrNull()
fun Intent.getByteExtraOrThrow(key: String): Byte = getByteExtraCatching(key).getOrThrow()
fun Intent.getByteExtraOrDefault(key: String, defaultValue: Byte): Byte = getByteExtraCatching(key).getOrDefault(defaultValue)

fun Intent.getByteArrayExtraCatching(key: String): Result<ByteArray> = checkNotNullCatching(key) { getByteArrayExtra(key) }
fun Intent.getByteArrayExtraOrNull(key: String): ByteArray? = getByteArrayExtraCatching(key).getOrNull()
fun Intent.getByteArrayExtraOrThrow(key: String): ByteArray = getByteArrayExtraCatching(key).getOrThrow()

fun Intent.getCharExtraCatching(key: String): Result<Char> = checkNotNullCatching(key) { getCharExtra(key, 0.toChar()) }
fun Intent.getCharExtraOrNull(key: String): Char? = getCharExtraCatching(key).getOrNull()
fun Intent.getCharExtraOrThrow(key: String): Char = getCharExtraCatching(key).getOrThrow()
fun Intent.getCharExtraOrDefault(key: String, defaultValue: Char): Char = getCharExtraCatching(key).getOrDefault(defaultValue)

fun Intent.getCharArrayExtraCatching(key: String): Result<CharArray> = checkNotNullCatching(key) { getCharArrayExtra(key) }
fun Intent.getCharArrayExtraOrNull(key: String): CharArray? = getCharArrayExtraCatching(key).getOrNull()
fun Intent.getCharArrayExtraOrThrow(key: String): CharArray = getCharArrayExtraCatching(key).getOrThrow()

fun Intent.getCharSequenceExtraCatching(key: String): Result<CharSequence> = checkNotNullCatching(key) { getCharSequenceExtra(key) }
fun Intent.getCharSequenceExtraOrNull(key: String): CharSequence? = getCharSequenceExtraCatching(key).getOrNull()
fun Intent.getCharSequenceExtraOrThrow(key: String): CharSequence = getCharSequenceExtraCatching(key).getOrThrow()

fun Intent.getCharSequenceArrayExtraCatching(key: String): Result<Array<CharSequence>> = checkNotNullCatching(key) { getCharSequenceArrayExtra(key) }
fun Intent.getCharSequenceArrayExtraOrNull(key: String): Array<CharSequence>? = getCharSequenceArrayExtraCatching(key).getOrNull()
fun Intent.getCharSequenceArrayExtraOrThrow(key: String): Array<CharSequence> = getCharSequenceArrayExtraCatching(key).getOrThrow()

fun Intent.getCharSequenceArrayListExtraCatching(key: String): Result<ArrayList<CharSequence>> = checkNotNullCatching(key) { getCharSequenceArrayListExtra(key) }
fun Intent.getCharSequenceArrayListExtraOrNull(key: String): ArrayList<CharSequence>? = getCharSequenceArrayListExtraCatching(key).getOrNull()
fun Intent.getCharSequenceArrayListExtraOrThrow(key: String): ArrayList<CharSequence> = getCharSequenceArrayListExtraCatching(key).getOrThrow()
fun Intent.getCharSequenceListExtraCatching(key: String): Result<List<CharSequence>> = getCharSequenceArrayListExtraCatching(key).mapCatching { it.toList() }
fun Intent.getCharSequenceListExtraOrNull(key: String): List<CharSequence>? = getCharSequenceListExtraCatching(key).getOrNull()
fun Intent.getCharSequenceListExtraOrThrow(key: String): List<CharSequence> = getCharSequenceListExtraCatching(key).getOrThrow()

fun Intent.getDoubleExtraCatching(key: String): Result<Double> = checkNotNullCatching(key) { getDoubleExtra(key, 0.0) }
fun Intent.getDoubleExtraOrNull(key: String): Double? = getDoubleExtraCatching(key).getOrNull()
fun Intent.getDoubleExtraOrThrow(key: String): Double = getDoubleExtraCatching(key).getOrThrow()
fun Intent.getDoubleExtraOrDefault(key: String, defaultValue: Double): Double = getDoubleExtraCatching(key).getOrDefault(defaultValue)

fun Intent.getDoubleArrayExtraCatching(key: String): Result<DoubleArray> = checkNotNullCatching(key) { getDoubleArrayExtra(key) }
fun Intent.getDoubleArrayExtraOrNull(key: String): DoubleArray? = getDoubleArrayExtraCatching(key).getOrNull()
fun Intent.getDoubleArrayExtraOrThrow(key: String): DoubleArray = getDoubleArrayExtraCatching(key).getOrThrow()

fun <T : Enum<T>> Intent.putEnumExtra(key: String, value: T?) = value?.let { putExtra(key, it.ordinal) }
inline fun <reified T : Enum<T>> Intent.getEnumExtraCatching(key: String): Result<T> = checkNotNullCatching(key) {
    getIntExtraOrThrow(key).let { ordinal ->
        requireNotNull(T::class.java.enumConstants)[ordinal]
    }
}

inline fun <reified T : Enum<T>> Intent.getEnumExtraOrNull(key: String): T? = getEnumExtraCatching<T>(key).getOrNull()
inline fun <reified T : Enum<T>> Intent.getEnumExtraOrThrow(key: String): T = getEnumExtraCatching<T>(key).getOrThrow()
inline fun <reified T : Enum<T>> Intent.getEnumExtraOrDefault(key: String, defaultValue: T): T = getEnumExtraCatching<T>(key).getOrDefault(defaultValue)
inline fun <reified T : Enum<T>> Intent.getEnumExtraOrElse(key: String, onFailure: (exception: Throwable) -> T): T = getEnumExtraCatching<T>(key).getOrElse(onFailure)

fun <T : Enum<T>> Intent.putExtra(key: String, value: List<T>) = putExtra(key, value.map { it.ordinal }.toIntArray())
inline fun <reified T : Enum<T>> Intent.getEnumListExtraCatching(key: String): Result<List<T>> = checkNotNullCatching(key) {
    getIntArrayExtraOrNull(key)?.let { ordinals ->
        val enumConstants = requireNotNull(T::class.java.enumConstants)
        ordinals.map { enumConstants[it] }.toList()
    }
}

inline fun <reified T : Enum<T>> Intent.getEnumListExtraOrNull(key: String): List<T>? = getEnumListExtraCatching<T>(key).getOrNull()
inline fun <reified T : Enum<T>> Intent.getEnumListExtraOrEmpty(key: String): List<T> = getEnumListExtraOrNull<T>(key) ?: emptyList()
inline fun <reified T : Enum<T>> Intent.getEnumListExtraOrThrow(key: String): List<T> = getEnumListExtraCatching<T>(key).getOrThrow()
inline fun <reified T : Enum<T>> Intent.getEnumListExtraOrDefault(key: String, defaultValue: List<T>): List<T> = getEnumListExtraCatching<T>(key).getOrDefault(defaultValue)
inline fun <reified T : Enum<T>> Intent.getEnumListExtraOrElse(key: String, onFailure: (exception: Throwable) -> List<T>): List<T> = getEnumListExtraCatching<T>(key).getOrElse(onFailure)

fun Intent.getFloatExtraCatching(key: String): Result<Float> = checkNotNullCatching(key) { getFloatExtra(key, 0.0f) }
fun Intent.getFloatExtraOrNull(key: String): Float? = getFloatExtraCatching(key).getOrNull()
fun Intent.getFloatExtraOrThrow(key: String): Float = getFloatExtraCatching(key).getOrThrow()
fun Intent.getFloatExtraOrDefault(key: String, defaultValue: Float): Float = getFloatExtraCatching(key).getOrDefault(defaultValue)

fun Intent.getFloatArrayExtraCatching(key: String): Result<FloatArray> = checkNotNullCatching(key) { getFloatArrayExtra(key) }
fun Intent.getFloatArrayExtraOrNull(key: String): FloatArray? = getFloatArrayExtraCatching(key).getOrNull()
fun Intent.getFloatArrayExtraOrThrow(key: String): FloatArray = getFloatArrayExtraCatching(key).getOrThrow()

fun Intent.getIntExtraCatching(key: String): Result<Int> = checkNotNullCatching(key) { getIntExtra(key, 0) }
fun Intent.getIntExtraOrNull(key: String): Int? = getIntExtraCatching(key).getOrNull()
fun Intent.getIntExtraOrThrow(key: String): Int = getIntExtraCatching(key).getOrThrow()
fun Intent.getIntExtraOrDefault(key: String, defaultValue: Int): Int = getIntExtraCatching(key).getOrDefault(defaultValue)

fun Intent.getIntArrayExtraCatching(key: String): Result<IntArray> = checkNotNullCatching(key) { getIntArrayExtra(key) }
fun Intent.getIntArrayExtraOrNull(key: String): IntArray? = getIntArrayExtraCatching(key).getOrNull()
fun Intent.getIntArrayExtraOrThrow(key: String): IntArray = getIntArrayExtraCatching(key).getOrThrow()

fun Intent.getIntegerArrayListExtraCatching(key: String): Result<ArrayList<Int?>> = checkNotNullCatching(key) { getIntegerArrayListExtra(key) }
fun Intent.getIntegerArrayListExtraOrNull(key: String): ArrayList<Int?>? = getIntegerArrayListExtraCatching(key).getOrNull()
fun Intent.getIntegerArrayListExtraOrThrow(key: String): ArrayList<Int?> = getIntegerArrayListExtraCatching(key).getOrThrow()
fun Intent.getIntegerListExtraCatching(key: String): Result<List<Int?>> = getIntegerArrayListExtraCatching(key).mapCatching { it.toList() }
fun Intent.getIntegerListExtraOrNull(key: String): List<Int?>? = getIntegerListExtraCatching(key).getOrNull()
fun Intent.getIntegerListExtraOrThrow(key: String): List<Int?> = getIntegerListExtraCatching(key).getOrThrow()

fun Intent.getLongExtraCatching(key: String): Result<Long> = checkNotNullCatching(key) { getLongExtra(key, 0L) }
fun Intent.getLongExtraOrNull(key: String): Long? = getLongExtraCatching(key).getOrNull()
fun Intent.getLongExtraOrThrow(key: String): Long = getLongExtraCatching(key).getOrThrow()
fun Intent.getLongExtraOrDefault(key: String, defaultValue: Long): Long = getLongExtraCatching(key).getOrDefault(defaultValue)

fun Intent.getLongArrayExtraCatching(key: String): Result<LongArray> = checkNotNullCatching(key) { getLongArrayExtra(key) }
fun Intent.getLongArrayExtraOrNull(key: String): LongArray? = getLongArrayExtraCatching(key).getOrNull()
fun Intent.getLongArrayExtraOrThrow(key: String): LongArray = getLongArrayExtraCatching(key).getOrThrow()

@Deprecated(message = "getParcelableExtraCompat is hidden", replaceWith = ReplaceWith("this.getParcelableExtraOrNull(key)"), level = DeprecationLevel.WARNING)
inline fun <reified T : Parcelable> Intent.getParcelableExtraCompat(key: String): T? = IntentCompat.getParcelableExtra(this, key, T::class.java)
inline fun <reified T : Parcelable> Intent.getParcelableExtraCatching(key: String): Result<T> = checkNotNullCatching(key) { getParcelableExtraCompat(key) }
inline fun <reified T : Parcelable> Intent.getParcelableExtraOrNull(key: String): T? = getParcelableExtraCatching<T>(key).getOrNull()
inline fun <reified T : Parcelable> Intent.getParcelableExtraOrThrow(key: String): T = getParcelableExtraCatching<T>(key).getOrThrow()

@Suppress("UNCHECKED_CAST")
@Deprecated(message = "getParcelableArrayExtraCompat is hidden", replaceWith = ReplaceWith("this.getParcelableArrayExtraOrNull(key)"), level = DeprecationLevel.WARNING)
inline fun <reified T : Parcelable> Intent.getParcelableArrayExtraCompat(key: String): Array<T>? = IntentCompat.getParcelableArrayExtra(this, key, T::class.java) as? Array<T>
inline fun <reified T : Parcelable> Intent.getParcelableArrayExtraCatching(key: String): Result<Array<T>> = checkNotNullCatching(key) { getParcelableArrayExtraCompat(key) }
inline fun <reified T : Parcelable> Intent.getParcelableArrayExtraOrNull(key: String): Array<T>? = getParcelableArrayExtraCatching<T>(key).getOrNull()
inline fun <reified T : Parcelable> Intent.getParcelableArrayExtraOrThrow(key: String): Array<T> = getParcelableArrayExtraCatching<T>(key).getOrThrow()

@Deprecated(message = "getParcelableArrayListExtraCompat is hidden", replaceWith = ReplaceWith("this.getParcelableArrayListExtraOrNull(key)"), level = DeprecationLevel.WARNING)
inline fun <reified T : Parcelable> Intent.getParcelableArrayListExtraCompat(key: String): ArrayList<T>? = IntentCompat.getParcelableArrayListExtra(this, key, T::class.java)
inline fun <reified T : Parcelable> Intent.getParcelableArrayListExtraCatching(key: String): Result<ArrayList<T>> = checkNotNullCatching(key) { getParcelableArrayListExtraCompat(key) }
inline fun <reified T : Parcelable> Intent.getParcelableArrayListExtraOrNull(key: String): ArrayList<T>? = getParcelableArrayListExtraCatching<T>(key).getOrNull()
inline fun <reified T : Parcelable> Intent.getParcelableArrayListExtraOrThrow(key: String): ArrayList<T> = getParcelableArrayListExtraCatching<T>(key).getOrThrow()
inline fun <reified T : Parcelable> Intent.getParcelableListExtraCatching(key: String): Result<List<T>> = checkNotNullCatching(key) { getParcelableArrayListExtraCompat<T>(key)?.toList() }
inline fun <reified T : Parcelable> Intent.getParcelableListExtraOrNull(key: String): List<T>? = getParcelableListExtraCatching<T>(key).getOrNull()
inline fun <reified T : Parcelable> Intent.getParcelableListExtraOrEmpty(key: String): List<T> = getParcelableListExtraOrNull<T>(key) ?: emptyList()
inline fun <reified T : Parcelable> Intent.getParcelableListExtraOrThrow(key: String): List<T> = getParcelableListExtraCatching<T>(key).getOrThrow()

@Deprecated(message = "getSerializableExtraCompat is hidden", replaceWith = ReplaceWith("this.getSerializableExtraOrNull(key)"), level = DeprecationLevel.WARNING)
inline fun <reified T : Serializable> Intent.getSerializableExtraCompat(key: String): T? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getSerializableExtra(key, T::class.java)
    } else {
        getSerializableExtra(key) as? T
    }
}

inline fun <reified T : Serializable> Intent.getSerializableExtraCatching(key: String): Result<T> = checkNotNullCatching(key) { getSerializableExtraCompat(key) }
inline fun <reified T : Serializable> Intent.getSerializableExtraOrNull(key: String): T? = getSerializableExtraCatching<T>(key).getOrNull()
inline fun <reified T : Serializable> Intent.getSerializableExtraOrThrow(key: String): T = getSerializableExtraCatching<T>(key).getOrThrow()

fun Intent.getShortExtraCatching(key: String): Result<Short> = checkNotNullCatching(key) { getShortExtra(key, 0) }
fun Intent.getShortExtraOrNull(key: String): Short? = getShortExtraCatching(key).getOrNull()
fun Intent.getShortExtraOrThrow(key: String): Short = getShortExtraCatching(key).getOrThrow()
fun Intent.getShortExtraOrDefault(key: String, defaultValue: Short): Short = getShortExtraCatching(key).getOrDefault(defaultValue)

fun Intent.getShortArrayExtraCatching(key: String): Result<ShortArray> = checkNotNullCatching(key) { getShortArrayExtra(key) }
fun Intent.getShortArrayExtraOrNull(key: String): ShortArray? = getShortArrayExtraCatching(key).getOrNull()
fun Intent.getShortArrayExtraOrThrow(key: String): ShortArray = getShortArrayExtraCatching(key).getOrThrow()

fun Intent.getStringExtraCatching(key: String): Result<String> = checkNotNullCatching(key) { getStringExtra(key) }
fun Intent.getStringExtraOrNull(key: String): String? = getStringExtraCatching(key).getOrNull()
fun Intent.getStringExtraOrThrow(key: String): String = getStringExtraCatching(key).getOrThrow()

fun Intent.getStringArrayExtraCatching(key: String): Result<Array<String>> = checkNotNullCatching(key) { getStringArrayExtra(key) }
fun Intent.getStringArrayExtraOrNull(key: String): Array<String>? = getStringArrayExtraCatching(key).getOrNull()
fun Intent.getStringArrayExtraOrThrow(key: String): Array<String> = getStringArrayExtraCatching(key).getOrThrow()

fun Intent.getStringArrayListExtraCatching(key: String): Result<ArrayList<String>> = checkNotNullCatching(key) { getStringArrayListExtra(key) }
fun Intent.getStringArrayListExtraOrNull(key: String): ArrayList<String>? = getStringArrayListExtraCatching(key).getOrNull()
fun Intent.getStringArrayListExtraOrThrow(key: String): ArrayList<String> = getStringArrayListExtraCatching(key).getOrThrow()
fun Intent.getStringListExtraCatching(key: String): Result<List<String>> = getStringArrayListExtraCatching(key).mapCatching { it.toList() }
fun Intent.getStringListExtraOrNull(key: String): List<String>? = getStringListExtraCatching(key).getOrNull()
fun Intent.getStringListExtraOrThrow(key: String): List<String> = getStringListExtraCatching(key).getOrThrow()
