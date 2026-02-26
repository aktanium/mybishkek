package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.mycity.data.Place

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    place: Place,
    onBack: () -> Unit,
    onOpenMap: () -> Unit
) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    val isWideScreen = screenWidth >= 700

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(place.name) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { padding ->

        if (isWideScreen) {
            // 📱 Планшет
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp)
            ) {

                Image(
                    painter = painterResource(id = place.imageRes),
                    contentDescription = place.name,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.width(24.dp))

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState())
                ) {

                    Text(
                        text = place.name,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = place.description,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = onOpenMap,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.LocationOn, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Open in Maps")
                    }
                }
            }

        } else {
            // 📱 Телефон
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(rememberScrollState())
            ) {

                Image(
                    painter = painterResource(id = place.imageRes),
                    contentDescription = place.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                    contentScale = ContentScale.Crop
                )

                Column(modifier = Modifier.padding(24.dp)) {

                    Text(
                        text = place.name,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = place.description,
                        style = MaterialTheme.typography.bodyLarge
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = onOpenMap,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(Icons.Default.LocationOn, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Open in Maps")
                    }
                }
            }
        }
    }
}