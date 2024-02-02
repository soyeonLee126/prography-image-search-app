package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.repository.datasource.UnsplashRemoteDataSource
import com.example.data.util.Constants.STARTING_OFFSET
import com.example.domain.usecase.model.UnSplashImage
import retrofit2.HttpException
import java.io.IOException

class RemotePagingSource(
    private val unsplashDatasource: UnsplashRemoteDataSource,
) : PagingSource<Int, UnSplashImage>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnSplashImage> {
        return try {
            val page = params.key ?: STARTING_OFFSET
            val response = unsplashDatasource.getImageList(page=page)

            val images = response.body()?.data?.results?.toMutableList() ?: emptyList()
            val nextPage = if (page >= response.body()?.data?.total!!) null else page + 1

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
        state: PagingState<Int, UnSplashImage>
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