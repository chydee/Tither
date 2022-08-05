package com.bethel.studio.tither.core.di

import android.content.Context
import com.bethel.studio.tither.core.SettingsContext
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModuleInjector {

    @Singleton
    @Provides
    fun provideSharedPrefs(@ApplicationContext context: Context) = SettingsContext(context)

}