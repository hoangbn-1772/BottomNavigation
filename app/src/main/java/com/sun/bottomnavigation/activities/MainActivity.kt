package com.sun.bottomnavigation.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        initComponents()
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

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_goto_custom -> gotoActivity(CustomActivity::class.java)
            R.id.button_goto_component -> gotoActivity(ComponentActivity::class.java)
        }
    }

    private fun initComponents() {
        bottom_navigation_basic?.setOnNavigationItemSelectedListener(this)
        button_goto_custom?.setOnClickListener(this)
        button_goto_component?.setOnClickListener(this)
        button_update_badge?.setOnClickListener(this)
        setupBadge()
        customBadge()
    }

    /**
     * Custom badge by inflate xml
     */
    private fun customBadge() {
        val tab = bottom_navigation_basic?.findViewById<BottomNavigationItemView>(R.id.action_favorite)
        val badgeView = LayoutInflater.from(this).inflate(R.layout.item_badge, tab, false)
        tab?.addView(badgeView)
    }

    /**
     * Use badge supported by BottomNavigation
     */
    @SuppressLint("RestrictedApi")
    private fun setupBadge() {
        val tab: FrameLayout = findViewById(R.id.action_near_me)
        /*Create instance of BadgeDrawable*/
        val badgeDrawable: BadgeDrawable = BadgeDrawable.create(this)
        BadgeUtils.attachBadgeDrawable(badgeDrawable, tab, null)
        BadgeUtils.setBadgeDrawableBounds(badgeDrawable, tab, null)
        /*Add and display BadgeDrawable*/
        val badge = bottom_navigation_basic.showBadge(R.id.action_near_me)
        badge.number = 10
        badge.backgroundColor = ContextCompat.getColor(this, R.color.color_secondary)
        badge.badgeTextColor = ContextCompat.getColor(this, R.color.color_on_primary)

        /*remove BadgeDrawables that are no longer needed.*/
//        bottom_navigation_basic?.removeBadge(R.id.action_near_me)
    }

    private fun gotoActivity(toClass: Class<*>) {
        Intent(this, toClass).apply {
            startActivity(this)
        }
    }
}
