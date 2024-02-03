package com.example.data.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "splash_images")
data class UnsplashImage(
    @PrimaryKey
    val id: String,
    val description: String?,
    @Embedded
    val urls: UnsplashPhotoUrls,
    @Embedded
    val user: UnsplashUser
): Parcelable {
    @Parcelize
    data class UnsplashPhotoUrls(
        val raw: String,
        val full: String,
        val regular: String,
        val small: String,
        val thumb: String
    ): Parcelable
    @Parcelize
    data class UnsplashUser(
        val name: String,
        val username: String
    ): Parcelable{
        val attributionUrl get() = "https://unsplash.com/$username?utm_source=UnsplashMVVM&utm_medium=referral"
    }
}