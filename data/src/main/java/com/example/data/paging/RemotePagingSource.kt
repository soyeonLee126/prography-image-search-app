package com.example.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.repository.datasource.UnsplashRemoteDataSource
import com.example.data.util.Constants.STARTING_OFFSET
import com.example.data.util.Mapper.toDomain
import com.example.domain.usecase.model.ImageModel
import retrofit2.HttpException
import java.io.IOException

class RemotePagingSource(
    private val unsplashDatasource: UnsplashRemoteDataSource,
) : PagingSource<Int, ImageModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageModel> {
        return try {
            val currentPage = params.key ?: STARTING_OFFSET
            val response = unsplashDatasource.getImageList(page = currentPage).body().toDomain()
            LoadResult.Page(
                data = response,
                prevKey = if (currentPage == STARTING_OFFSET) null else currentPage - 1,
                nextKey = if (response.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ImageModel>): Int? {
        return state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
    }

}