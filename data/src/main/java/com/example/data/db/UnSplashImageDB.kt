package com.example.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.model.UnsplashImage
@Database(
    entities = [UnsplashImage::class],
    version = 2,
)
abstract class UnSplashImageDB : RoomDatabase() {
    abstract fun unsplashImageDao(): UnSplashImageDAO
}