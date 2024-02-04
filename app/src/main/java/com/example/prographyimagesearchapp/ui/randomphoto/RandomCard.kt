package com.example.prographyimagesearchapp.ui.randomphoto

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.domain.usecase.model.ImageModel
import com.example.prographyimagesearchapp.R
import androidx.compose.material3.Card
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.prographyimagesearchapp.ui.navigation.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RandomCard(
    modifier: Modifier = Modifier,
    navController: NavController,
    item: ImageModel,
    state: PagerState
) {
    Card(
        modifier
            .padding(20.dp)
            .width(330.dp)
    ) {
        Column(
            modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            if (item.urls != null) {
            Column(verticalArrangement = Arrangement.SpaceEvenly) {
                    AsyncImage(
                        model = item.urls.regular,
                        contentDescription = "",
                        contentScale = ContentScale.FillWidth,
                        modifier = modifier
                            .fillMaxWidth()
                            .height(450.dp)
                    )
                    DetailCardBottomBar(navController = navController, item = item, state = state)
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailCardBottomBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    item: ImageModel,
    viewModel: RandomPhotoViewModel = hiltViewModel(),
    state: PagerState
) {
    val swipeFlow = viewModel.swipeFlow.collectAsState(initial = false)

    LaunchedEffect(swipeFlow.value) {
        if(swipeFlow.value) {
            state.animateScrollToPage(state.currentPage + 1)
        }
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxWidth()
            .height(180.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.notinterestedbutton),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .clickable {
                    viewModel.swipe()
                }
        )
        Image(
            painter = painterResource(id = R.drawable.bookmarkbutton),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .clickable { viewModel.saveImage(item) }
        )
        Image(
            painter = painterResource(id = R.drawable.informationbutton),
            contentDescription = null,
            modifier = Modifier
                .padding(20.dp)
                .clickable {
                    navController.navigate(
                        route = "${
                            Screen.Detail.route.replace(
                                "itemId",
                                item.id
                            )
                        }",
                    )
                }
        )
    }
}