package com.example.data.util

import android.media.Image
import com.example.data.model.UnsplashImage
import com.example.domain.usecase.model.ImageModel

object Mapper {
    fun List<UnsplashImage>?.toDomain(): List<ImageModel> {
        val responseList = mutableListOf<ImageModel>()
        this?.forEach {
           val response = ImageModel(
               id = it.id,
               description = it.description,
               urls = it.urls.regular,
           )
           responseList.add(response)
       }
        return responseList
    }

    fun UnsplashImage?.toDomain(): ImageModel {
        return this?.let {
            ImageModel(
                id = id,
                description = description,
                urls = urls.regular,
            )
        }?: ImageModel("", "", "")
    }

    fun ImageModel?.toData(): UnsplashImage {
        return this?.let {
            UnsplashImage(
                id = it.id,
                description = it.description,
                urls = UnsplashImage.UnsplashPhotoUrls(it.urls),
            )
        }?: UnsplashImage("", "", UnsplashImage.UnsplashPhotoUrls(""))
    }
}