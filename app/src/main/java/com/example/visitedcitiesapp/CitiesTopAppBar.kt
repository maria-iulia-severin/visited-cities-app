package com.example.visitedcitiesapp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitiesTopAppBar(onSort: () -> Unit) {
    val topBarIcon = painterResource(R.drawable.ic_sort)

    TopAppBar(
        title = { Text(text = "Cities") },
        actions = {
            IconButton(onClick = onSort) {
                Icon(
                    painter = topBarIcon,
                    contentDescription = null
                )
            }
        })
}