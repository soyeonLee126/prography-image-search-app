package com.example.data.repository

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.db.UnSplashImageDAO
import com.example.data.paging.LocalPagingSource
import com.example.data.paging.RemotePagingSource
import com.example.data.paging.RemoteRandomImagePagingSource
import com.example.data.repository.datasource.UnsplashRemoteDataSource
import com.example.data.util.Constants.LOAD_SIZE
import com.example.data.util.Mapper.toData
import com.example.data.util.Mapper.toDomain
import com.example.domain.repository.UnsplashImageRepository
import com.example.domain.usecase.model.ImageModel
import kotlinx.coroutines.flow.Flow
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
        return remoteDataSource.getImageDetail(id).body().toDomain()
    }

    override suspend fun getImageDetailFromDB(id: String): ImageModel? {
        return unsplashImageDao.getImageDetail(id).getOrElse(0, { null }).toDomain()
    }

    override fun getRandomImage(): Flow<PagingData<ImageModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = LOAD_SIZE,
                enablePlaceholders = false,
            ),
            pagingSourceFactory = { RemoteRandomImagePagingSource(remoteDataSource) }
        ).flow
    }

    override suspend fun saveImage(image: ImageModel) = unsplashImageDao.saveImage(image.toData())

    override suspend fun deleteSavedImage(image: ImageModel) = unsplashImageDao.deleteImage(image.toData())
}