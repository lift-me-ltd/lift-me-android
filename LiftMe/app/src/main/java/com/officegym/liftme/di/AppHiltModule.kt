package com.officegym.liftme.di

import com.officegym.liftme.navigation.LMNavigator
import com.officegym.liftme.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppHiltModule {
    @Singleton
    @Provides
    fun provideNavigator(): Navigator {
        return LMNavigator()
    }
}
