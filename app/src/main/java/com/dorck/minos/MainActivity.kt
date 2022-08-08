package com.dorck.minos

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    class SomethingNew : SimpleInterface {
        @SuppressLint("KotlinTodo")
        override fun initialize() {
            TODO("Not yet implemented")
        }

        override fun doSomething() {
            TODO("Not yet implemented")
        }

    }
}