package com.example.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.db.UnSplashImageDAO
import com.example.domain.usecase.model.UnSplashImage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class LocalPagingSource(
    private val unSplashImageDao: UnSplashImageDAO,
) :
    PagingSource<Int, UnSplashImage>() {
    override fun getRefreshKey(state: PagingState<Int, UnSplashImage>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnSplashImage> {
        val start = params.key ?: 1
        return try {
            var data: List<UnSplashImage>? = null

            CoroutineScope(Dispatchers.IO).launch {
                data = unSplashImageDao.getAllImage(start)
            }.join()

            LoadResult.Page(
                data = data!!,
                prevKey = if (start == 1) null else start-1,
                nextKey = if(data.isNullOrEmpty()) null else start+1
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}