package com.example.prographyimagesearchapp.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.prographyimagesearchapp.R
import com.example.prographyimagesearchapp.ui.utilcomponent.SingleImage

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val lazyListState = rememberLazyListState()

    val imageList = viewModel.getImageListUseCase.collectAsLazyPagingItems()
    val bookmarkList = viewModel.bookmarkedListUseCase.collectAsLazyPagingItems()

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
                if (bookmarkList.itemCount > 0) TabText(text = stringResource(id = R.string.head_bookmark))
                LazyRow(modifier = modifier.fillMaxWidth()) {
                    items(bookmarkList.itemCount) { index ->
                        bookmarkList[index]?.let {
                            SingleImage(item = it, navController = navController)
                        }
                    }
                }
            }
            item {
                if (imageList.itemCount > 0) TabText(text = stringResource(id = R.string.head_recent))
            }
            items(imageList.itemCount) { index ->
                imageList[index]?.let {
                    SingleImage(item = it, navController = navController)
                }
            }
//            items(imageList.itemCount / 2) { rowIndex ->
//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.SpaceBetween
//                ) {
//                    val index1 = rowIndex * 2
//                    imageList[index1]?.let { SingleImage(item = it, navController = navController) }
//
//                    val index2 = rowIndex * 2 + 1
//                    imageList[index2]?.let { SingleImage(item = it, navController = navController) }
//                }
        }
    }
}
