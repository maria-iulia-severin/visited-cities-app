package com.example.visitedcitiesapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CityItem(city: String, country: String) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth(1f)
            .padding(5.dp)
            .background(Color.LightGray)
    ) {
        Text(text = city, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = country, fontSize = 15.sp)
    }
}