package com.example.converters.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.converters.model.RecentResult

@Composable
fun RecentCalculation(
    modifier: Modifier,
    recentCalculations: List<RecentResult>
) {

    if (recentCalculations.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "No recent calculations!!", color = Color.Gray)
        }
    } else {
        Column(modifier = modifier) {
            Text(
                text = "HISTORY",
                style = MaterialTheme.typography.h6.copy(
                    color = MaterialTheme.colors.primary,
                    fontWeight = FontWeight.Medium
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(recentCalculations) {
                    SingleRecentCalculation(recentCalculation = it)
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }

    }
}