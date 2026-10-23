package com.example.lab7

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavController

@Composable
fun DriversScreen(navController: NavController) {
    var driver by remember { mutableStateOf("") }
    val drivers = remember { mutableStateListOf<String>() }

    Column {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.testTag("driversBackButton")
        ) { Text("Back") }

        Text("FormulaZero Drivers")

        TextField(
            value = driver,
            onValueChange = { driver = it },
            modifier = Modifier.testTag("driverInput")
        )

        Button(
            onClick = {
                if (driver.isNotBlank()) {
                    drivers.add(driver)
                    driver = ""
                }
            },
            modifier = Modifier.testTag("addDriverButton")
        ) { Text("Add") }

        Button(
            onClick = { drivers.clear() },
            modifier = Modifier.testTag("clearDriversButton")
        ) { Text("Clear All") }

        LazyColumn {
            items(drivers) { Text(it) }
        }
    }
}