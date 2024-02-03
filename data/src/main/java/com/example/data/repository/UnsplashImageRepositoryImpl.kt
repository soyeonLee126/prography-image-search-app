package com.example.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.db.UnSplashImageDAO
import com.example.data.model.UnsplashImage
import com.example.data.paging.LocalPagingSource
import com.example.data.paging.RemotePagingSource
import com.example.data.repository.datasource.UnsplashRemoteDataSource
import com.example.data.util.Constants.LOAD_SIZE
import com.example.data.util.Mapper.toData
import com.example.data.util.Mapper.toDomain
import com.example.domain.repository.UnsplashImageRepository
import com.example.domain.usecase.model.ImageModel
import com.example.domain.usecase.model.Urls
import com.example.domain.usecase.model.User
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Singleton

@Singleton
class UnsplashImageRepositoryImpl(
    private val remoteDataSource: UnsplashRemoteDataSource,
    private val unsplashImageDao: UnSplashImageDAO
): UnsplashImageRepository {
    override fun getImageList(): Flow<PagingData<ImageModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = LOAD_SIZE,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { RemotePagingSource(remoteDataSource) }
        ).flow
    }

    override fun getSavedImageList(): Flow<PagingData<ImageModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = LOAD_SIZE,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { LocalPagingSource(unsplashImageDao) }
        ).flow

    }

    override suspend fun getImageDetail(id: String): ImageModel {
        Log.e("111111", "getImageDetail: ${remoteDataSource.getImageDetail(id)}")
        return remoteDataSource.getImageDetail(id).body().toDomain()
    }

    override suspend fun getRandomImage(): List<ImageModel> = remoteDataSource.getRandomImage().body().toDomain()

    override suspend fun saveImage(image: ImageModel) = unsplashImageDao.saveImage(image.toData())

    override suspend fun deleteSavedImage(image: ImageModel) = unsplashImageDao.deleteImage(image.toData())
}