package com.wada811.adx.core.generator

import java.util.*

enum class Params(
    val className: String,
    val targetClassName: String = className,
    val applicableMethodName: String,
    val replacementMethodNames: List<String>,
    val methodParamsText: String = "\"\""
) {
    BundleGetBinder(
        className = "android.os.Bundle",
        applicableMethodName = "getBinder",
        replacementMethodNames = listOf("getBinderOrNull", "getBinderOrThrow")
    ),
    BundleGetBoolean(
        className = "android.os.Bundle",
        targetClassName = "android.os.BaseBundle",
        applicableMethodName = "getBoolean",
        replacementMethodNames = listOf("getBooleanOrNull", "getBooleanOrThrow")
    ),
    BundleGetBooleanArray(
        className = "android.os.Bundle",
        targetClassName = "android.os.BaseBundle",
        applicableMethodName = "getBooleanArray",
        replacementMethodNames = listOf("getBooleanArrayOrNull", "getBooleanArrayOrThrow")
    ),
    BundleGetBundle(
        className = "android.os.Bundle",
        applicableMethodName = "getBundle",
        replacementMethodNames = listOf("getBundleOrNull", "getBundleOrThrow")
    ),
    BundleGetByte(
        className = "android.os.Bundle",
        applicableMethodName = "getByte",
        replacementMethodNames = listOf("getByteOrNull", "getByteOrThrow")
    ),
    BundleGetByteArray(
        className = "android.os.Bundle",
        applicableMethodName = "getByteArray",
        replacementMethodNames = listOf("getByteArrayOrNull", "getByteArrayOrThrow")
    ),
    BundleGetChar(
        className = "android.os.Bundle",
        applicableMethodName = "getChar",
        replacementMethodNames = listOf("getCharOrNull", "getCharOrThrow")
    ),
    BundleGetCharArray(
        className = "android.os.Bundle",
        applicableMethodName = "getCharArray",
        replacementMethodNames = listOf("getCharArrayOrNull", "getCharArrayOrThrow")
    ),
    BundleGetCharSequence(
        className = "android.os.Bundle",
        applicableMethodName = "getCharSequence",
        replacementMethodNames = listOf("getCharSequenceOrNull", "getCharSequenceOrThrow")
    ),
    BundleGetCharSequenceArray(
        className = "android.os.Bundle",
        applicableMethodName = "getCharSequenceArray",
        replacementMethodNames = listOf("getCharSequenceArrayOrNull", "getCharSequenceArrayOrThrow")
    ),
    BundleGetCharSequenceArrayList(
        className = "android.os.Bundle",
        applicableMethodName = "getCharSequenceArrayList",
        replacementMethodNames = listOf("getCharSequenceArrayListOrNull", "getCharSequenceArrayListOrThrow")
    ),
    BundleGetDouble(
        className = "android.os.Bundle",
        targetClassName = "android.os.BaseBundle",
        applicableMethodName = "getDouble",
        replacementMethodNames = listOf("getDoubleOrNull", "getDoubleOrThrow")
    ),
    BundleGetDoubleArray(
        className = "android.os.Bundle",
        targetClassName = "android.os.BaseBundle",
        applicableMethodName = "getDoubleArray",
        replacementMethodNames = listOf("getDoubleArrayOrNull", "getDoubleArrayOrThrow")
    ),
    BundleGetFloat(
        className = "android.os.Bundle",
        applicableMethodName = "getFloat",
        replacementMethodNames = listOf("getFloatOrNull", "getFloatOrThrow")
    ),
    BundleGetFloatArray(
        className = "android.os.Bundle",
        applicableMethodName = "getFloatArray",
        replacementMethodNames = listOf("getFloatArrayOrNull", "getFloatArrayOrThrow")
    ),
    BundleGetInt(
        className = "android.os.Bundle",
        targetClassName = "android.os.BaseBundle",
        applicableMethodName = "getInt",
        replacementMethodNames = listOf("getIntOrNull", "getIntOrThrow")
    ),
    BundleGetIntArray(
        className = "android.os.Bundle",
        targetClassName = "android.os.BaseBundle",
        applicableMethodName = "getIntArray",
        replacementMethodNames = listOf("getIntArrayOrNull", "getIntArrayOrThrow")
    ),
    BundleGetIntegerArrayList(
        className = "android.os.Bundle",
        applicableMethodName = "getIntegerArrayList",
        replacementMethodNames = listOf("getIntegerArrayListOrNull", "getIntegerArrayListOrThrow")
    ),
    BundleGetLong(
        className = "android.os.Bundle",
        targetClassName = "android.os.BaseBundle",
        applicableMethodName = "getLong",
        replacementMethodNames = listOf("getLongOrNull", "getLongOrThrow")
    ),
    BundleGetLongArray(
        className = "android.os.Bundle",
        targetClassName = "android.os.BaseBundle",
        applicableMethodName = "getLongArray",
        replacementMethodNames = listOf("getLongArrayOrNull", "getLongArrayOrThrow")
    ),
    BundleGetShort(
        className = "android.os.Bundle",
        applicableMethodName = "getShort",
        replacementMethodNames = listOf("getShortOrNull", "getShortOrThrow")
    ),
    BundleGetShortArray(
        className = "android.os.Bundle",
        applicableMethodName = "getShortArray",
        replacementMethodNames = listOf("getShortArrayOrNull", "getShortArrayOrThrow")
    ),
    BundleGetSize(
        className = "android.os.Bundle",
        applicableMethodName = "getSize",
        replacementMethodNames = listOf("getSizeOrNull", "getSizeOrThrow")
    ),
    BundleGetSizeF(
        className = "android.os.Bundle",
        applicableMethodName = "getSizeF",
        replacementMethodNames = listOf("getSizeFOrNull", "getSizeFOrThrow")
    ),
    BundleGetString(
        className = "android.os.Bundle",
        targetClassName = "android.os.BaseBundle",
        applicableMethodName = "getString",
        replacementMethodNames = listOf("getStringOrNull", "getStringOrThrow")
    ),
    BundleGetStringArray(
        className = "android.os.Bundle",
        targetClassName = "android.os.BaseBundle",
        applicableMethodName = "getStringArray",
        replacementMethodNames = listOf("getStringArrayOrNull", "getStringArrayOrThrow")
    ),
    BundleGetStringArrayList(
        className = "android.os.Bundle",
        applicableMethodName = "getStringArrayList",
        replacementMethodNames = listOf("getStringArrayListOrNull", "getStringArrayListOrThrow")
    ),
    IntentGetBoolean(
        className = "android.content.Intent",
        applicableMethodName = "getBooleanExtra",
        replacementMethodNames = listOf("getBooleanExtraOrNull", "getBooleanExtraOrThrow"),
        methodParamsText = """"", false"""
    ),
    IntentGetBooleanArray(
        className = "android.content.Intent",
        applicableMethodName = "getBooleanArrayExtra",
        replacementMethodNames = listOf("getBooleanArrayExtraOrNull", "getBooleanArrayExtraOrThrow")
    ),
    IntentGetBundle(
        className = "android.content.Intent",
        applicableMethodName = "getBundleExtra",
        replacementMethodNames = listOf("getBundleExtraOrNull", "getBundleExtraOrThrow")
    ),
    IntentGetByte(
        className = "android.content.Intent",
        applicableMethodName = "getByteExtra",
        replacementMethodNames = listOf("getByteExtraOrNull", "getByteExtraOrThrow"),
        methodParamsText = """"", 0"""
    ),
    IntentGetByteArray(
        className = "android.content.Intent",
        applicableMethodName = "getByteArrayExtra",
        replacementMethodNames = listOf("getByteArrayExtraOrNull", "getByteArrayExtraOrThrow")
    ),
    IntentGetChar(
        className = "android.content.Intent",
        applicableMethodName = "getCharExtra",
        replacementMethodNames = listOf("getCharExtraOrNull", "getCharExtraOrThrow"),
        methodParamsText = """"", 0.toChar()"""
    ),
    IntentGetCharArray(
        className = "android.content.Intent",
        applicableMethodName = "getCharArrayExtra",
        replacementMethodNames = listOf("getCharArrayExtraOrNull", "getCharArrayExtraOrThrow")
    ),
    IntentGetCharSequence(
        className = "android.content.Intent",
        applicableMethodName = "getCharSequenceExtra",
        replacementMethodNames = listOf("getCharSequenceExtraOrNull", "getCharSequenceExtraOrThrow")
    ),
    IntentGetCharSequenceArray(
        className = "android.content.Intent",
        applicableMethodName = "getCharSequenceArrayExtra",
        replacementMethodNames = listOf("getCharSequenceArrayExtraOrNull", "getCharSequenceArrayExtraOrThrow")
    ),
    IntentGetCharSequenceArrayList(
        className = "android.content.Intent",
        applicableMethodName = "getCharSequenceArrayListExtra",
        replacementMethodNames = listOf("getCharSequenceArrayListExtraOrNull", "getCharSequenceArrayListExtraOrThrow")
    ),
    IntentGetDouble(
        className = "android.content.Intent",
        applicableMethodName = "getDoubleExtra",
        replacementMethodNames = listOf("getDoubleExtraOrNull", "getDoubleExtraOrThrow"),
        methodParamsText = """"", 0.0"""
    ),
    IntentGetDoubleArray(
        className = "android.content.Intent",
        applicableMethodName = "getDoubleArrayExtra",
        replacementMethodNames = listOf("getDoubleArrayExtraOrNull", "getDoubleArrayExtraOrThrow")
    ),
    IntentGetFloat(
        className = "android.content.Intent",
        applicableMethodName = "getFloatExtra",
        replacementMethodNames = listOf("getFloatExtraOrNull", "getFloatExtraOrThrow"),
        methodParamsText = """"", 0f"""
    ),
    IntentGetFloatArray(
        className = "android.content.Intent",
        applicableMethodName = "getFloatArrayExtra",
        replacementMethodNames = listOf("getFloatArrayExtraOrNull", "getFloatArrayExtraOrThrow")
    ),
    IntentGetInt(
        className = "android.content.Intent",
        applicableMethodName = "getIntExtra",
        replacementMethodNames = listOf("getIntExtraOrNull", "getIntExtraOrThrow"),
        methodParamsText = """"", 0"""
    ),
    IntentGetIntArray(
        className = "android.content.Intent",
        applicableMethodName = "getIntArrayExtra",
        replacementMethodNames = listOf("getIntArrayExtraOrNull", "getIntArrayExtraOrThrow")
    ),
    IntentGetIntegerArrayList(
        className = "android.content.Intent",
        applicableMethodName = "getIntegerArrayListExtra",
        replacementMethodNames = listOf("getIntegerArrayListExtraOrNull", "getIntegerArrayListExtraOrThrow")
    ),
    IntentGetLong(
        className = "android.content.Intent",
        applicableMethodName = "getLongExtra",
        replacementMethodNames = listOf("getLongExtraOrNull", "getLongExtraOrThrow"),
        methodParamsText = """"", 0L"""
    ),
    IntentGetLongArray(
        className = "android.content.Intent",
        applicableMethodName = "getLongArrayExtra",
        replacementMethodNames = listOf("getLongArrayExtraOrNull", "getLongArrayExtraOrThrow")
    ),
    IntentGetShort(
        className = "android.content.Intent",
        applicableMethodName = "getShortExtra",
        replacementMethodNames = listOf("getShortExtraOrNull", "getShortExtraOrThrow"),
        methodParamsText = """"", 0"""
    ),
    IntentGetShortArray(
        className = "android.content.Intent",
        applicableMethodName = "getShortArrayExtra",
        replacementMethodNames = listOf("getShortArrayExtraOrNull", "getShortArrayExtraOrThrow")
    ),
    IntentGetString(
        className = "android.content.Intent",
        applicableMethodName = "getStringExtra",
        replacementMethodNames = listOf("getStringExtraOrNull", "getStringExtraOrThrow")
    ),
    IntentGetStringArray(
        className = "android.content.Intent",
        applicableMethodName = "getStringArrayExtra",
        replacementMethodNames = listOf("getStringArrayExtraOrNull", "getStringArrayExtraOrThrow")
    ),
    IntentGetStringArrayList(
        className = "android.content.Intent",
        applicableMethodName = "getStringArrayListExtra",
        replacementMethodNames = listOf("getStringArrayListExtraOrNull", "getStringArrayListExtraOrThrow")
    ),
    ;

    private val simpleClassName = className.split(".").last()
    val lowerClassName = simpleClassName.replaceFirstChar { it.lowercase(Locale.ROOT) }
    val upperClassName = simpleClassName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
    private val upperMethodName = applicableMethodName.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    val upperClassMethodName = upperClassName + upperMethodName
    val imports = replacementMethodNames.map { "com.wada811.adx.${lowerClassName}.$it" }
    val importsText = imports.joinToString { "\"$it\"" }
    val replacementMethodNameValues = replacementMethodNames.joinToString { "\"$it\"" }
    val replacementMethodNamesText = replacementMethodNames.joinToString(" or ")
}
