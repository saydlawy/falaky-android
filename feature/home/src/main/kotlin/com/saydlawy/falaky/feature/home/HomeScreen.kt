package com.saydlawy.falaky.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Button
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text

/** Stage 1 placeholder: one focusable button so D-pad focus is exercised from the first build. */
@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen(versionName: String, onContinue: () -> Unit = {}) {
    Column(
        modifier = Modifier.fillMaxSize().padding(48.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("فلكي  Falaky", style = MaterialTheme.typography.displayMedium, color = MaterialTheme.colorScheme.primary)
        Text("v$versionName", style = MaterialTheme.typography.bodyLarge)
        Button(onClick = onContinue) { Text("Start") }
    }
}
