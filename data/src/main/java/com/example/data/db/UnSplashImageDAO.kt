package com.example.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.usecase.model.UnSplashImage

@Dao
interface UnSplashImageDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveImage(splashImage: UnSplashImage)
    @Query("SELECT * FROM splash_images ORDER BY id ASC LIMIT 10 OFFSET (:page-1)*10")
    fun getAllImage(page:Int): List<UnSplashImage>
    @Delete
    suspend fun deleteImage(splashImage: UnSplashImage)
}