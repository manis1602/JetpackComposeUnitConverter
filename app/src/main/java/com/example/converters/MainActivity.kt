package com.example.converters

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.Surface
import com.example.converters.composables.ConverterScreen
import com.example.converters.ui.theme.ConvertersTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConvertersTheme {
                Surface {
                    ConverterScreen()
                }
            }
        }
    }
}