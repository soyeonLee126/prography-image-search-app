package com.example.data.api

import com.example.data.BuildConfig
import com.example.data.model.UnsplashImage
import com.example.data.util.Constants.CLIENT_ID
import com.example.data.util.Constants.LOAD_SIZE
import com.example.domain.usecase.model.ImageModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnSplashApi {
    @Headers("Accept-Version: v1", "Authorization: Client-ID ${BuildConfig.UNSPLASH_ACCESS_KEY}")
    @GET("/photos")
    suspend fun getImageList(
        @Query(
            "page"
        ) offset: Int,
        @Query(
            "per_page"
        ) perPage:Int = LOAD_SIZE,
    ): Response<List<UnsplashImage>>

    @GET("/photos")
    suspend fun getRandomImage(
        @Query(
            "page"
        ) offset: Int,
        @Query(
            "per_page"
        ) ts:String,
        @Query(
            "apikey"
        ) apiKey: String,
    ): Response<UnsplashImage>

    @GET("/photos")
    suspend fun getImageDetail(
        @Query(
            "id"
        ) id: String
    ): Response<UnsplashImage>
}