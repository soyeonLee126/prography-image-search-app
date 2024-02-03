package com.example.prographyimagesearchapp.ui.randomphoto

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.domain.usecase.model.ImageModel
import com.example.prographyimagesearchapp.R

@Composable
fun Card(
    modifier: Modifier = Modifier,
    item: ImageModel,
    cardStackController: CardStackController
) {
    Box(modifier = modifier) {
        if (item.urls != null) {
            AsyncImage(
                model = item.urls.regular,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
        }
        Column(
            modifier = modifier
                .align(Alignment.BottomStart)
                .padding(10.dp)
        ) {
            Text(
                text = item.description.toString(),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.notinterestedbutton),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(20.dp)
                        .clickable {
                            cardStackController.swipeLeft()
                        },
                )
                Image(
                    painter = painterResource(id = R.drawable.bookmarkbutton),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(20.dp)
                        .clickable {
                            cardStackController.swipeRight()
                        },
                )
                Image(
                    painter = painterResource(id = R.drawable.informationbutton),
                    contentDescription = null,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}