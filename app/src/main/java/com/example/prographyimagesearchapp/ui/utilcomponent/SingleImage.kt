package com.example.prographyimagesearchapp.ui.utilcomponent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.domain.usecase.model.ImageModel
import com.example.prographyimagesearchapp.ui.navigation.Screen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets


@Composable
fun SingleImage(
    modifier: Modifier = Modifier,
    navController: NavController,
    item: ImageModel,
) {
    Box(
        modifier = modifier
            .padding(5.dp)
            .fillMaxWidth(0.9f),
        contentAlignment = Alignment.BottomStart
    ) {
        LoadingView(modifier = Modifier.fillMaxWidth())
        Card(
            modifier = modifier
                .padding(top = 10.dp)
                .wrapContentHeight()
                .clickable {
                    navController.navigate(
                        "${
                            Screen.Detail.route.replace(
                                "itemId",
                                item.id
                            )
                        }"
                    )
                }
        ) {
            AsyncImage(
                contentScale = ContentScale.FillHeight,
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.urls.regular)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
            )
        }
        item.description?.let {
            Text(
                maxLines = 2,
                color = Color.White,
                text = it,
                modifier = modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            )
        }
    }
}
