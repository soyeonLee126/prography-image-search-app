package com.example.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.model.UnsplashImage
import com.example.domain.usecase.model.ImageModel

@Dao
interface UnSplashImageDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveImage(splashImage: UnsplashImage)
    @Query("SELECT * FROM splash_images ORDER BY id ASC LIMIT 10 OFFSET (:page-1)*10")
    fun getAllImage(page:Int): List<UnsplashImage>
    @Query("SELECT * FROM splash_images WHERE id = :id")
    fun getImageDetail(id:String): List<UnsplashImage>
    @Delete
    fun deleteImage(splashImage: UnsplashImage)
}