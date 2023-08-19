package com.lbg.testapp.data.cache.system

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Siva kumar boddu 
 */
class PreferencesHelper constructor(context: Context) {

    companion object {
        private const val PREF_WISE_TEST_PACKAGE_NAME = "com.lbg.testapp.preferences"
        private const val PREF_KEY_LAST_CACHE = "last_cache"
    }

    private val wiseTestPref: SharedPreferences

    init {
        wiseTestPref = context.getSharedPreferences(PREF_WISE_TEST_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    var lastCacheTime: Long
        get() = wiseTestPref.getLong(PREF_KEY_LAST_CACHE, 0)
        set(lastCache) = wiseTestPref.edit().putLong(PREF_KEY_LAST_CACHE, lastCache).apply()

}
