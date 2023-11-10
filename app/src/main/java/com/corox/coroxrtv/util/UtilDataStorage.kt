package com.corox.coroxrtv.util

import android.content.Context
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.corox.coroxrtv.dataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject



class UtilDataStorage @Inject constructor(@ApplicationContext private val contexto: Context) {


    suspend fun saveStringPreference(key: String, value: String) {
        contexto.dataStore.edit { preferences ->
            preferences[stringPreferencesKey(key)] = value
        }
    }

    suspend fun saveBooleanPreference(key: String, value: Boolean) {
        contexto.dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }
    }

    fun getBooleanPrefence(key: String): Flow <Boolean> {

        return contexto.dataStore.data.map {
                preferences ->
            preferences[booleanPreferencesKey(key)] ?: false
        }
    }
    fun getStringPreference(key: String):Flow<String>{
        return contexto.dataStore.data.map {
            preferences ->
            preferences[stringPreferencesKey(key)]?:""
        }
    }

}