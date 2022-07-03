package com.example.cleanarchitecturemvvm.di.core

import android.content.Context
import com.example.cleanarchitecturemvvm.presentation.BaseActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val context: Context) {
    @Provides
    fun provideBaseActivity(): BaseActivity =
        context as BaseActivity
}