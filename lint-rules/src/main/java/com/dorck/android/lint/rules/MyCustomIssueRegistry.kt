package com.dorck.android.lint.rules

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.dorck.android.lint.rules.issues.JcenterDetector
import com.dorck.android.lint.rules.issues.KotlinTodoDetector

@Suppress("UnstableApiUsage")
class MyCustomIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(
            JcenterDetector.ISSUE,
            KotlinTodoDetector.ISSUE,
        )

    override val minApi: Int
        get() = 8 // works with Studio 4.1 or later; see com.android.tools.lint.detector.api.Api / ApiKt

    override val api: Int
        get() = CURRENT_API

}