package com.example.prographyimagesearchapp.ui.randomphoto

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun RandomPhotoScreen(
    navController: NavController,
    viewModel: RandomPhotoViewModel = hiltViewModel(),
) {
    val imageList = viewModel.getRandomImage.collectAsLazyPagingItems()
    val pagerState = rememberPagerState{ imageList.itemCount}
    HorizontalPager(modifier = Modifier.fillMaxWidth(), state = pagerState) { page ->
        RandomCard(navController = navController, item = imageList[page]!!, state = pagerState)
    }
}

