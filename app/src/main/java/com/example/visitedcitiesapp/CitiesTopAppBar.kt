package com.example.visitedcitiesapp

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CitiesTopAppBar() {
    val topBarIcon = painterResource(R.drawable.ic_filter)
    val showFilters = remember { mutableStateOf(false) }

    TopAppBar(
        title = { Text(text = "Cities") },
        actions = {
            IconButton(onClick = { showFilters.value = true }) {
                Icon(
                    painter = topBarIcon,
                    contentDescription = null
                )
            }
            DropdownMenu(
                expanded = showFilters.value,
                onDismissRequest = { showFilters.value = false }) {
                DropdownMenuItem(text = { Text(text = "Filter A - Z") }, onClick = { /*TODO*/ })
                DropdownMenuItem(text = { Text(text = "Filter Z - A") }, onClick = { /*TODO*/ })
            }

        })
}