package com.example.prographyimagesearchapp.ui.utilcomponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import coil.compose.AsyncImage
import coil.request.ImageRequest
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun SingleImage(
    imageUrl: String = "https://fastly.picsum.photos/id/468/200/300.jpg?hmac=_y9LVzJfrmELvOun_dpNOKoPajv8_vT3t3IPS6Jbhk4"
) {
     Card(
        modifier = Modifier
            .padding(top = 10.dp)
            .height(180.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(
                    all = 15.dp
                ),
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
            )

        }
    }
}

@Preview
@Composable
fun SingleImagePreview() {
    SingleImage()
}