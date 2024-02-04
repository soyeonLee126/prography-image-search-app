package com.example.prographyimagesearchapp.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.prographyimagesearchapp.R
import com.example.prographyimagesearchapp.ui.utilcomponent.EmptyItem
import com.example.prographyimagesearchapp.ui.utilcomponent.LoadingView
import com.example.prographyimagesearchapp.ui.utilcomponent.SingleImage

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val lazyListState = rememberLazyListState()
    val lazyGridListState = rememberLazyStaggeredGridState()

    val imageList = viewModel.getImageListUseCase.collectAsLazyPagingItems()
    val bookmarkList = viewModel.bookmarkedListUseCase.collectAsLazyPagingItems()

    LaunchedEffect(lazyGridListState){
        Log.e("1111111", "HomeScreen: 111111", )
    }

    Surface(modifier = modifier.fillMaxWidth()) {
        LazyColumn(
            state = lazyListState,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
                Divider(
                    modifier = modifier
                        .padding(10.dp, 0.dp)
                        .fillMaxWidth()
                )
            }
            item {
                if (bookmarkList.itemCount > 0) {
                    TabText(text = stringResource(id = R.string.head_bookmark))
                    LazyRow(
                        modifier = modifier
                            .fillMaxWidth()
                            .height(180.dp)
                    ) {
                        items(bookmarkList.itemCount) { index ->
                            bookmarkList[index]?.let {
                                SingleImage(
                                    item = it,
                                    navController = navController,
                                )
                            }
                        }
                    }
                }
            }
            item {
                if (imageList.itemCount > 0) TabText(text = stringResource(id = R.string.head_recent)) else EmptyItem()
            }
            item {
                LazyVerticalStaggeredGrid(
                    state = lazyGridListState,
                    columns = StaggeredGridCells.Fixed(count = 2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1400.dp)
                ) {
                    items(imageList.itemCount) { index ->
                        imageList[index]?.let {
                            SingleImage(
                                item = it,
                                navController = navController,
                                modifier = Modifier.width(180.dp)
                            )
                        }
                    }
                }
            }
        }
    }

}
