package com.dorck.android.lint.rules.issues

import com.android.tools.lint.detector.api.*
import com.intellij.psi.PsiMethod
import org.jetbrains.uast.UCallExpression

/**
 * Detect usage of kotlin TODO usage to avoid of NotImplementedError.
 * <p>
 * `TODO("Not yet implemented")`
 * </p>
 * @author Dorck
 * @since 2022/08/07
 */
@Suppress("UnstableApiUsage")
class KotlinTodoDetector : Detector(), Detector.UastScanner {

    override fun getApplicableMethodNames(): List<String> {
        return listOf("TODO")
    }

    override fun visitMethodCall(context: JavaContext, node: UCallExpression, method: PsiMethod) {
        println("KotlinTodoDetector >>> matched TODO in [${method.parent.containingFile.toString()}]")
        if (context.evaluator.isMemberInClass(method, "kotlin.StandardKt__StandardKt")) {
            val deleteFix = fix().name("Delete this TODO method")
                .replace().all().with("").build()
            context.report(
                ISSUE,
                context.getLocation(node),
                "You must fix `TODO()` first.", deleteFix)
        }
    }

    companion object {
        private const val ISSUE_ID = "KotlinTodo"
        val ISSUE = Issue.create(
            ISSUE_ID,
            "Detecting `TODO()` method from kotlin/Standard.kt.",
            """
                You have unimplemented method or undo work marked by `TODO()`,
                please implement it or remove dangerous TODO.
                """,
            category = Category.CORRECTNESS,
            priority = 9,
            severity = Severity.ERROR,
            implementation = Implementation(KotlinTodoDetector::class.java, Scope.JAVA_FILE_SCOPE),
        )
    }
}