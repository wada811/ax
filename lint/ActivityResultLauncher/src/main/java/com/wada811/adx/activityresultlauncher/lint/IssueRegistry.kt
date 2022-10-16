package com.wada811.adx.activityresultlauncher.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

@Suppress("UnstableApiUsage", "unused")
class IssueRegistry : IssueRegistry() {
    override val issues: List<Issue> = listOf(
        UseActivityResultLauncherLaunchDetector.ISSUE,
    )
    override val api: Int = CURRENT_API
    override val minApi: Int = 8
    override val vendor: Vendor = Vendor(
        vendorName = "@wada811",
        identifier = "adx",
        feedbackUrl = "https://github.com/wada811/adx"
    )
}
