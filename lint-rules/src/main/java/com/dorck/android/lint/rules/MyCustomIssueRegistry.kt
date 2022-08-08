package com.dorck.android.lint.rules

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

@Suppress("UnstableApiUsage")
class MyCustomIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(

        )

    override val minApi: Int
        get() = 8 // works with Studio 4.1 or later; see com.android.tools.lint.detector.api.Api / ApiKt

    override val api: Int
        get() = CURRENT_API

}