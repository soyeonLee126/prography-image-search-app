package com.example.prographyimagesearchapp.ui.utilcomponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.domain.usecase.model.ImageModel
import com.example.prographyimagesearchapp.ui.navigation.Screen


@Composable
fun SingleImage(
    navController: NavController,
    item: ImageModel,
) {
    Box(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Card(
            modifier = Modifier
                .padding(top = 10.dp)
                .width(180.dp)
                .wrapContentHeight()
                .clickable { navController.navigate("${Screen.Detail.route.replace("itemId", item.id)}") }
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.urls.regular)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
            )
        }
        item.description?.let {
            Text(
                color = Color.White,
                text = it.take(20),
                modifier = Modifier
                    .padding(20.dp)
            )
        }
    }
}
