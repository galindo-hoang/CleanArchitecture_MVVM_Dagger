package com.example.cleanarchitecturemvvm.di

import android.content.Context
import com.example.cleanarchitecturemvvm.presentation.BaseActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ActivityComponent::class)
class ActivityModule() {
//    @Provides
//    fun provideBaseActivity(@ApplicationContext context: Context): BaseActivity =
//        context as BaseActivity
}