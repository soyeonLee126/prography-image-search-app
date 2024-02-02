package com.example.prographyimagesearchapp.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prographyimagesearchapp.ui.utilcomponent.SingleImage

@Composable
fun BookmarkImageList(
//    image: LazyPagingItems<UnSplashImage>,
) {
    LazyRow(
    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
    ) {
        items(5) { index ->
            index?.let {
                SingleImage()
            }
        }
    }
}

@Composable
fun RecentImageList(
//    image: LazyPagingItems<UnSplashImage>,
) {
    LazyVerticalGrid(
        userScrollEnabled = false,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(max = 700.dp)
            .wrapContentHeight(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(10) { index ->
                Card(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                ) {
                    SingleImage()
                }
            }
        }
    )
}
