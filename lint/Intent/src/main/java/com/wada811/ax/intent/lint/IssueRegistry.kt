package com.wada811.ax.intent.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

@Suppress("UnstableApiUsage", "unused")
class IssueRegistry : IssueRegistry() {
    override val issues: List<Issue> = listOf(
        UseIntentGetBooleanArrayExtraDetector.ISSUE,
        UseIntentGetBooleanExtraDetector.ISSUE,
        UseIntentGetBundleExtraDetector.ISSUE,
        UseIntentGetByteArrayExtraDetector.ISSUE,
        UseIntentGetByteExtraDetector.ISSUE,
        UseIntentGetCharArrayExtraDetector.ISSUE,
        UseIntentGetCharExtraDetector.ISSUE,
        UseIntentGetCharSequenceArrayExtraDetector.ISSUE,
        UseIntentGetCharSequenceArrayListExtraDetector.ISSUE,
        UseIntentGetCharSequenceExtraDetector.ISSUE,
        UseIntentGetDoubleArrayExtraDetector.ISSUE,
        UseIntentGetDoubleExtraDetector.ISSUE,
        UseIntentGetFloatArrayExtraDetector.ISSUE,
        UseIntentGetFloatExtraDetector.ISSUE,
        UseIntentGetIntArrayExtraDetector.ISSUE,
        UseIntentGetIntegerArrayListExtraDetector.ISSUE,
        UseIntentGetIntExtraDetector.ISSUE,
        UseIntentGetLongArrayExtraDetector.ISSUE,
        UseIntentGetLongExtraDetector.ISSUE,
        UseIntentGetParcelableArrayExtraDetector.ISSUE,
        UseIntentGetParcelableArrayListExtraDetector.ISSUE,
        UseIntentGetParcelableExtraDetector.ISSUE,
        UseIntentGetSerializableExtraDetector.ISSUE,
        UseIntentGetShortArrayExtraDetector.ISSUE,
        UseIntentGetShortExtraDetector.ISSUE,
        UseIntentGetStringArrayDetector.ISSUE,
        UseIntentGetStringArrayListDetector.ISSUE,
        UseIntentGetStringDetector.ISSUE
    )
    override val api: Int = CURRENT_API
    override val minApi: Int = 8
    override val vendor: Vendor = Vendor(
        vendorName = "@wada811",
        identifier = "ax",
        feedbackUrl = "https://github.com/wada811/ax"
    )
}
