package com.dorck.lint.examples

import com.android.tools.lint.checks.infrastructure.TestFiles.kotlin
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import com.dorck.android.lint.rules.issues.KotlinTodoDetector
import org.junit.Test

@Suppress("UnstableApiUsage")
class KotlinTodoDetectorTest {

    @Test
    fun sampleTest() {
        lint().files(
            kotlin(
                """
                    package test.pkg
                    class SimpleInterfaceImpl : SimpleInterface {
                    
                        override fun doSomething(){
                            TODO("Not yet implemented")
                        }
                    }
                    interface SimpleInterface {
                        fun doSomething()
                    }
                """.trimIndent()
            ))
            .issues(KotlinTodoDetector.ISSUE)
            .run()
            .expect(
                """
                    src/test/pkg/SimpleInterfaceImpl.kt:5: Error: You must fix TODO() first. [KotlinTodo]
                            TODO("Not yet implemented")
                            ~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    1 errors, 0 warnings
                """.trimIndent()
            )
            .expectFixDiffs(
                """
                    Fix for src/test/pkg/SimpleInterfaceImpl.kt line 5: Delete this TODO method:
                    @@ -5 +5
                    -         TODO("Not yet implemented")
                """.trimIndent()
            )
    }
}