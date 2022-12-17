package com.devfestcochin.adoptadog.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.devfestcochin.adoptadog.R

@Composable
fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Hey Nithish,",
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.surface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Adopt a new friend near you!",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.surface
            )
        }

        TextButton(onClick = { }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_location),
                tint = Color.Red,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Cochin",
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.surface
            )
        }


    }
}