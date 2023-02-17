package com.wada811.ax.bundle.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

@Suppress("UnstableApiUsage", "unused")
class IssueRegistry : IssueRegistry() {
    override val issues: List<Issue> = listOf(
        UseBundleGetBinderDetector.ISSUE,
        UseBundleGetBooleanArrayDetector.ISSUE,
        UseBundleGetBooleanDetector.ISSUE,
        UseBundleGetBundleDetector.ISSUE,
        UseBundleGetByteArrayDetector.ISSUE,
        UseBundleGetByteDetector.ISSUE,
        UseBundleGetCharArrayDetector.ISSUE,
        UseBundleGetCharDetector.ISSUE,
        UseBundleGetCharSequenceArrayDetector.ISSUE,
        UseBundleGetCharSequenceArrayListDetector.ISSUE,
        UseBundleGetCharSequenceDetector.ISSUE,
        UseBundleGetDoubleArrayDetector.ISSUE,
        UseBundleGetDoubleDetector.ISSUE,
        UseBundleGetFloatArrayDetector.ISSUE,
        UseBundleGetFloatDetector.ISSUE,
        UseBundleGetIntArrayDetector.ISSUE,
        UseBundleGetIntDetector.ISSUE,
        UseBundleGetIntegerArrayListDetector.ISSUE,
        UseBundleGetLongArrayDetector.ISSUE,
        UseBundleGetLongDetector.ISSUE,
        UseBundleGetParcelableArrayDetector.ISSUE,
        UseBundleGetParcelableArrayListDetector.ISSUE,
        UseBundleGetParcelableDetector.ISSUE,
        UseBundleGetSerializableDetector.ISSUE,
        UseBundleGetShortArrayDetector.ISSUE,
        UseBundleGetShortDetector.ISSUE,
        UseBundleGetSizeDetector.ISSUE,
        UseBundleGetSizeFDetector.ISSUE,
        UseBundleGetSparseParcelableArrayDetector.ISSUE,
        UseBundleGetStringArrayDetector.ISSUE,
        UseBundleGetStringArrayListDetector.ISSUE,
        UseBundleGetStringDetector.ISSUE
    )
    override val api: Int = CURRENT_API
    override val minApi: Int = 8
    override val vendor: Vendor = Vendor(
        vendorName = "@wada811",
        identifier = "ax",
        feedbackUrl = "https://github.com/wada811/ax"
    )
}
