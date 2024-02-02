package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.usecase.model.UnSplashImage
@Database(
    entities = [UnSplashImage::class],
    version = 1,
)
abstract class UnSplashImageDB : RoomDatabase() {
    abstract fun unsplashImageDao(): UnSplashImageDAO
}