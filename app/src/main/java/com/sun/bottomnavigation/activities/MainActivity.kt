package com.sun.bottomnavigation.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sun.bottomnavigation.R
import com.sun.bottomnavigation.R.layout
import kotlinx.android.synthetic.main.activity_main.bottom_navigation_basic

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        initComponents()
        showNotification()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.action_recent -> {
                Toast.makeText(this, "Recent", Toast.LENGTH_SHORT).show()
            }
            R.id.action_favorite -> {
                Toast.makeText(this, "Favorite", Toast.LENGTH_SHORT).show()
            }
            R.id.action_near_me -> {
                Toast.makeText(this, "Near", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }

    private fun initComponents() {
        bottom_navigation_basic?.setOnNavigationItemSelectedListener(this)
        setupBadge()
//        customBadge()
    }

    private fun customBadge() {
        val tab = bottom_navigation_basic?.findViewById<BottomNavigationItemView>(R.id.action_near_me)
        val badgeView = LayoutInflater.from(this).inflate(R.layout.item_badge, tab, false)
        tab?.addView(badgeView)
    }

    @SuppressLint("RestrictedApi")
    private fun setupBadge() {
        val tab: FrameLayout = findViewById(R.id.frame_layout)
        val badgeDrawable: BadgeDrawable = BadgeDrawable.create(this)
        badgeDrawable.backgroundColor = ContextCompat.getColor(this, R.color.color_accent)
        badgeDrawable.badgeTextColor = ContextCompat.getColor(this, R.color.color_white)
        BadgeUtils.attachBadgeDrawable(badgeDrawable, tab, null)
        val badge = bottom_navigation_basic.showBadge(R.id.action_near_me)
        badge.number = 10
    }

    private fun showNotification() {
    }
}
