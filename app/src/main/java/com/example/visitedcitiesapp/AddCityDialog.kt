package com.example.visitedcitiesapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddCityDialog(onDismiss: () -> Unit, onConfirm: (name: String, country: String) -> Unit) {
    var cityNameState by remember { mutableStateOf(TextFieldValue("")) }
    var countryNameState by remember { mutableStateOf(TextFieldValue("")) }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = "Add a city",
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(modifier = Modifier.fillMaxWidth(1f)) {
                TextField(
                    value = cityNameState,
                    onValueChange = { cityNameState = it },
                    label = { Text("City Name") },
                    modifier = Modifier.padding(5.dp)
                )
                TextField(
                    value = countryNameState,
                    onValueChange = { countryNameState = it },
                    label = { Text("Country Name") },
                    modifier = Modifier.padding(5.dp)
                )
            }
        },
        confirmButton = {
            Button(onClick = {
                val n = cityNameState.text
                val c = countryNameState.text
                if (n.isNotEmpty() && c.isNotEmpty()) {
                    onConfirm.invoke(n, c)
                }
            }) {
                Text(text = "Add")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text(text = "Cancel")
            }
        }
    )
}