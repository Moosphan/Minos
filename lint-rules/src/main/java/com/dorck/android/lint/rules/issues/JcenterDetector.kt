package com.dorck.android.lint.rules.issues

import com.android.tools.lint.detector.api.*

/**
 * Detect for deprecated usage of jcenter.
 * @author Dorck
 * @since 2022/08/07
 */
@Suppress("UnstableApiUsage")
class JcenterDetector : Detector(), GradleScanner {

    override fun checkMethodCall(
        context: GradleContext,
        statement: String,
        parent: String?,
        namedArguments: Map<String, String>,
        unnamedArguments: List<String>,
        cookie: Any
    ) {
        if (statement == "jcenter" && parent == "repositories") {
            println("JcenterDetector >>> matched jcenter in [${parent}]")
            val replaceFix = fix().name("Replace with mavenCentral now.")
                .replace().text("jcenter").with("mavenCentral").build()
            context.report(
                ISSUE,
                cookie,
                context.getLocation(cookie),
                "Don't use `jcenter()` any more", replaceFix)
        }
    }

    companion object {
        private const val ISSUE_ID = "JcenterDeprecated"
        val ISSUE = Issue.create(
            ISSUE_ID,
            "Detecting `jcenter` repository usage.",
            """
                JCenter Maven repository is no longer receiving updates, 
                please migrate to other maven repos.
                """,
            category = Category.CORRECTNESS,
            priority = 9,
            severity = Severity.ERROR,
            implementation = Implementation(JcenterDetector::class.java, Scope.GRADLE_SCOPE),
            moreInfo = "https://developer.android.com/r/tools/jcenter-end-of-service"
        )
    }

}