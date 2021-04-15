package com.example.sampleapp.data.repository

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import com.example.sampleapp.domain.OpenApplicationRepository
import kotlinx.coroutines.flow.*
import java.io.IOException

class DataStoreOpenApplicationRepository(context: Context) : OpenApplicationRepository {

    companion object {
        val KEY_OPEN_APP = preferencesKey<Boolean>("key_first_open_app")
    }

    private val applicationContext = context.applicationContext
    private val dataStore: DataStore<Preferences>

    init {
        dataStore = applicationContext.createDataStore(
            name = "app_preferences"
        )
    }

    override fun checkIsFirstOpen(): Flow<Boolean> = dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            preferences[KEY_OPEN_APP] ?: true
        }.onEach { isFirstOpen ->
            if (isFirstOpen) setOpenApplicationInfo()

        }.take(1)

    private suspend fun setOpenApplicationInfo() {
        dataStore.edit { preferences ->
            preferences[KEY_OPEN_APP] = false
        }
    }
}