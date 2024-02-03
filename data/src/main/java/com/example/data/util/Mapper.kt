package com.example.data.util

import com.example.data.model.UnsplashImage
import com.example.domain.usecase.model.ImageModel
import com.example.domain.usecase.model.Urls
import com.example.domain.usecase.model.User

object Mapper {
    fun List<UnsplashImage>?.toDomain(): List<ImageModel> {
        val responseList = mutableListOf<ImageModel>()
        this?.forEach {
           val response = ImageModel(
               id = it.id,
               description = it.description,
               urls = Urls(it.urls.raw, it.urls.full, it.urls.regular, it.urls.small, it.urls.thumb),
               user = User(it.user.name, it.user.username)
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
                urls = Urls(it.urls.raw, it.urls.full, it.urls.regular, it.urls.small, it.urls.thumb),
                user = User(it.user.name, it.user.username)
            )
        }?: ImageModel("", "", Urls("", "", "", "", ""), User("", ""))
    }

    fun ImageModel?.toData(): UnsplashImage {
        return this?.let {
            UnsplashImage(
                id = it.id,
                description = it.description,
                urls = UnsplashImage.UnsplashPhotoUrls(it.urls.raw, it.urls.full, it.urls.regular, it.urls.small, it.urls.thumb),
                user = UnsplashImage.UnsplashUser(it.user.name, it.user.username)
            )
        }?: UnsplashImage("", "", UnsplashImage.UnsplashPhotoUrls("", "", "", "", ""), UnsplashImage.UnsplashUser("", ""))
    }
}