package com.example.geomob

import android.content.Context

class Setting(context: Context) {

    private val filename = "net.yuzumone.nowsearch.pref"
    private val preference = context.getSharedPreferences(filename, 0)
    private val DARK_MODE = "dark_mode"

    var darkMode
        get() = preference.getBoolean(DARK_MODE, false)
        set(value) = preference.edit().putBoolean(DARK_MODE, value).apply()
}