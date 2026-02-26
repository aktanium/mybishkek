package com.example.mycity.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.Nature
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onCategoryClick: (String) -> Unit
) {

    val categories = listOf(
        "Restaurants" to Icons.Default.Fastfood,
        "Parks" to Icons.Default.Nature,
        "Museums" to Icons.Default.AccountBalance,
        "Shopping" to Icons.Default.ShoppingCart,
        "Attractions" to Icons.Default.Place
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFF3F0FF),
                        Color(0xFFE5DEFF)
                    )
                )
            )
    ) {

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 180.dp),
            contentPadding = PaddingValues(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Header
            item(span = { androidx.compose.foundation.lazy.grid.GridItemSpan(maxLineSpan) }) {

                Column {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Discover Bishkek",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Explore the best places in the city",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }

            // Categories
            items(categories) { (title, icon) ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onCategoryClick(title) },
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            imageVector = icon,
                            contentDescription = title,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(36.dp)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    }
}