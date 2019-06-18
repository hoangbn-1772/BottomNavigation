package com.sun.bottomnavigation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sun.bottomnavigation.R

class ComponentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_component)
    }
}
