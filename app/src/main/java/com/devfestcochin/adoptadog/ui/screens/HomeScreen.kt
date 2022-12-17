package com.devfestcochin.adoptadog.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devfestcochin.adoptadog.data.FakeDogDatabase.dogList
import com.devfestcochin.adoptadog.ui.components.HomeTopBar
import com.devfestcochin.adoptadog.ui.components.ItemDogCard

@Composable
fun HomeScreen(
    navController: NavController
) {

    val items = remember {
        dogList
    }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {

        item {
            HomeTopBar()
        }

        items.forEach {
            item {
                ItemDogCard(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    dog = it,
                    onItemClicked = {
                        navController.navigate("details/${it.id}")
                    }
                )
            }

        }
    }
}
