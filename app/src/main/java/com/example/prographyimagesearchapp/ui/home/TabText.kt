package com.example.prographyimagesearchapp.ui.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TabText(text: String) {
    Text(
        style = MaterialTheme.typography.headlineLarge,
        color = if(isSystemInDarkTheme()) Color.White else Color.Black,
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .padding(10.dp),
    )
}
