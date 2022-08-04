package com.bethel.studio.tither.core

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import javax.inject.Singleton

@Singleton
class SettingsContext constructor(applicationContext: Context) {
    private val config: SharedPreferences

    init {
        config = EncryptedSharedPreferences.create(
            applicationContext,
            CONFIG_NAME,
            MasterKey.Builder(applicationContext, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    companion object {
        private const val CONFIG_NAME = "config"
        private const val KEY_SHOW_ONBOARDING = "show_on_boarding"
    }

    var shouldShowOnboarding: Boolean
        get() = config.getBoolean(KEY_SHOW_ONBOARDING, true)
        set(value) = config.edit().putBoolean(KEY_SHOW_ONBOARDING, value).apply()

}