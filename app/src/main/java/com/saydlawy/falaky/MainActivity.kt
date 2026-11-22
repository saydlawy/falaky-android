package com.saydlawy.falaky

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.saydlawy.falaky.feature.home.HomeScreen
import com.saydlawy.falaky.ui.theme.FalakyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FalakyTheme {
                HomeScreen(versionName = BuildConfig.VERSION_NAME)
            }
        }
    }
}
