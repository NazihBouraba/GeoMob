package com.example.geomob

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.twitter.sdk.android.core.BuildConfig
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig

class TwitterActivity : AppCompatActivity() {

    companion object {
        lateinit var context : Context

    }

    private val setting by lazy { Setting(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context = this
        val key = ""
        val secret = ""
        val config = TwitterConfig.Builder(this)
            .twitterAuthConfig(TwitterAuthConfig(key, secret))
            .build()
        Twitter.initialize(config)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(android.R.id.content, SearchFragment()).commit()
            supportFragmentManager.addOnBackStackChangedListener {
                if (supportFragmentManager.backStackEntryCount > 0) {
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                } else {
                    supportActionBar?.setDisplayHomeAsUpEnabled(false)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        menu.findItem(R.id.menu_dark).isChecked = setting.darkMode
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            R.id.menu_dark -> {
                item.isChecked = !item.isChecked
                setting.darkMode = item.isChecked
                finish()
                startActivity(intent)
                return true
            }
            R.id.menu_license -> {
                supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, LicenseFragment())
                    .addToBackStack(null).commit()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
