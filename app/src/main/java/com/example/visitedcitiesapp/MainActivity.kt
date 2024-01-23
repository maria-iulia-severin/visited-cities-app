package com.example.visitedcitiesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.visitedcitiesapp.ui.theme.VisitedcitiesappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitedcitiesappTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val locationList = remember { mutableListOf<Location>() }
                    val sort = remember {
                        mutableStateOf(false)
                    }
                    val sortedList =
                        if (sort.value) locationList.sortedBy { it.cityName[0] } else locationList

                    ScaffoldCitiesApp(
                        sortedList,
                        onAddCity = { name, country ->
                            locationList.add(Location(name, country))
                        },
                        onSort = {
                            sort.value = !sort.value
                        })
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldCitiesApp(
    list: List<Location>,
    onAddCity: (name: String, country: String) -> Unit,
    onSort: () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { CitiesTopAppBar(onSort = onSort) },
        floatingActionButton = {
            CitiesFloatingButton {
                showDialog = true
            }
        }
    ) {

        if (list.isEmpty()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "No cities available")
            }
        } else {
            CitiesList(list, modifier = Modifier.padding(it))
        }
    }

    if (showDialog) {
        AddCityDialog(
            onDismiss = { showDialog = false },
            onConfirm = { name, country ->
                showDialog = false
                onAddCity.invoke(name, country)
            })
    }
}
