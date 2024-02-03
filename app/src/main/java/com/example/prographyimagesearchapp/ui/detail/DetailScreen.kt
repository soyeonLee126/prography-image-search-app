package com.example.prographyimagesearchapp.ui.detail

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.example.prographyimagesearchapp.R
import com.example.prographyimagesearchapp.ui.home.HomeViewModel
import kotlinx.coroutines.flow.collect

@Composable
fun DetailScreen(
    navController: NavController, id: String, viewModel: DetailViewModel = hiltViewModel(),
) {
    viewModel.getImageDetail(id)
    val imageDetail = viewModel.imageDetailFlow.collectAsState(initial = null)
    Column {
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.popBackStack()
                    },
                painter = painterResource(id = R.drawable.closebutton),
                contentDescription = null,
            )
            Text(
                text = "userName",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp, end = 40.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = null,
                modifier = Modifier.padding(20.dp),
            )
            Image(
                painter = painterResource(id = R.drawable.bookmark),
                contentDescription = null,
                modifier = Modifier.padding(20.dp),
            )
        }
        AsyncImage(
            model = imageDetail.value?.urls?.full,
            contentDescription = "",
            contentScale = ContentScale.Crop,
        )
    }
}
