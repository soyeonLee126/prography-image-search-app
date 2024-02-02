package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.model.UnsplashImage
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
            val page = params.key ?: STARTING_OFFSET
            val response = unsplashDatasource.getImageList(page=page)

            val images = response.body().toDomain()
            val nextPage = page + 1

            LoadResult.Page(
                data = images,
                prevKey = null,
                nextKey = nextPage
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(
        state: PagingState<Int, ImageModel>
    ): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(
                anchorPosition
            )
            anchorPage?.prevKey?.plus(1) ?:
            anchorPage?.nextKey?.minus(1)
        }
    }
}