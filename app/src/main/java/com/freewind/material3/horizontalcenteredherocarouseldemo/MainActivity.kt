    @file:OptIn(ExperimentalMaterial3Api::class)

    package com.freewind.material3.horizontalcenteredherocarouseldemo

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.items
    import androidx.compose.foundation.text.input.rememberTextFieldState
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.*
    import androidx.compose.material3.*
import androidx.compose.material3.carousel.*
    import androidx.compose.material3.pulltorefresh.PullToRefreshBox
    import androidx.compose.runtime.*
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.state.ToggleableState
    import androidx.compose.ui.unit.dp

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                MaterialTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        DemoScreen()
                    }
                }
            }
        }
    }

    @Composable
    private fun DemoScreen() {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = { Text("HorizontalCenteredHeroCarousel") },
                    )
                },
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    val cards = listOf("One", "Two", "Three", "Four")
                    val state = rememberCarouselState { cards.size }
                    HorizontalCenteredHeroCarousel(state = state, modifier = Modifier.fillMaxWidth(), maxItemWidth = 240.dp) { index ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp),
                        ) {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center,
                            ) {
                                Text(cards[index], style = MaterialTheme.typography.headlineMedium)
                            }
                        }
                    }

                }
            }

    }
