package com.example.prographyimagesearchapp.di

import android.app.Application
import androidx.room.Room
import com.example.data.db.UnSplashImageDAO
import com.example.data.db.UnSplashImageDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(app: Application): UnSplashImageDB =
        Room.databaseBuilder(app, UnSplashImageDB::class.java, "splash_images").fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideImageDao(unSplashImageDB: UnSplashImageDB) : UnSplashImageDAO = unSplashImageDB.unsplashImageDao()

}