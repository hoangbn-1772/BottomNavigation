package com.sun.bottomnavigation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.bottomnavigation.R

class CustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)
    }
}
