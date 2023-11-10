package com.corox.coroxrtv

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.HiltAndroidApp
val Context.dataStore by preferencesDataStore(name = "FIRST_PREFERENCES")
@HiltAndroidApp
class CxAplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}