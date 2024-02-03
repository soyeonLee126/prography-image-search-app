package com.example.prographyimagesearchapp.ui.randomphoto

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.domain.usecase.model.ImageModel
import com.example.domain.usecase.model.Urls
import com.example.domain.usecase.model.User
import com.example.prographyimagesearchapp.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RandomPhotoScreen(
    navController: NavController,
    viewModel: RandomPhotoViewModel = hiltViewModel(),
) {
    viewModel.getRandomImage()
    val randomImage = viewModel.imageFlow.collectAsState(null)
    Column {
        randomImage.value?.let { CardStack(items = it) }
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            Button(
                shape = CircleShape,
                onClick = { navController.popBackStack() },
                modifier = Modifier.size(50.dp),
            ) {
                Image(
                    modifier = Modifier.size(40.dp),
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = null,
                )
            }
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
    }
}
