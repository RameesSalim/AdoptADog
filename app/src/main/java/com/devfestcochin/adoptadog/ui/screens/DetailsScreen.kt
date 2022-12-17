package com.devfestcochin.adoptadog.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.devfestcochin.adoptadog.data.FakeDogDatabase
import com.devfestcochin.adoptadog.model.Dog
import com.devfestcochin.adoptadog.ui.components.DogInfoCard
import com.devfestcochin.adoptadog.ui.components.InfoCard
import com.devfestcochin.adoptadog.ui.components.OwnerCard
import com.devfestcochin.adoptadog.ui.components.Title

@Composable
fun DetailsScreen(
    navController: NavController,
    id: Int
) {

    val dog = remember {
        FakeDogDatabase.dogList[id]
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Details") },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.surface,
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp, 24.dp),
                            tint = MaterialTheme.colors.surface
                        )
                    }
                },
            )
        },
        content = {
            DetailsScreenContent(
                modifier = Modifier.padding(it),
                dog = dog
            )
        }
    )
}


@Composable
fun DetailsScreenContent(
    modifier: Modifier,
    dog: Dog
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {

        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(346.dp),
                painter = painterResource(id = dog.image),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            DogInfoCard(dog.name, dog.gender, dog.location)
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            Title(title = "My Story")
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = dog.about,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                color = MaterialTheme.colors.surface,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Start
            )
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            Title(title = "Dog info")
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InfoCard(title = "Age", value = dog.age.toString().plus(" yrs"))
                InfoCard(title = "Color", value = dog.color)
                InfoCard(title = "Weight", value = dog.weight.toString().plus("Kg"))
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            Title(title = "Owner info")
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            OwnerCard(dog.owner.name, dog.owner.bio, dog.owner.image)
        }

        item {
            Spacer(modifier = Modifier.height(36.dp))
        }

        // CTA - Adopt me button
        item {
            Button(
                onClick = { /* Do something! */ },
                shape= RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(16.dp, 0.dp, 16.dp, 0.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                )
            ) {
                Text("Adopt me")
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }

}