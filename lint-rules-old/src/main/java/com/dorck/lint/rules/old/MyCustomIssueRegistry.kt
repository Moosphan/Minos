package com.dorck.lint.rules.old

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.dorck.lint.rules.old.issues.JcenterDetector
import com.dorck.lint.rules.old.issues.KotlinTodoDetector

@Suppress("UnstableApiUsage")
class MyCustomIssueRegistry : IssueRegistry() {
    init {
        println("MyCustomIssueRegistry, run...")
    }

    override val issues: List<Issue>
        get() = listOf(
            JcenterDetector.ISSUE,
            KotlinTodoDetector.ISSUE,
        )

    override val minApi: Int
        get() = 8 // works with Studio 4.1 or later; see com.android.tools.lint.detector.api.Api / ApiKt

    override val api: Int
        get() = CURRENT_API

    override val vendor: Vendor
        get() = Vendor(
            vendorName = "Dorck",
            contact = "moosphon@gmail.com"
        )

}