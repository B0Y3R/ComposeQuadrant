package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColumnWithLayout {
                        val modifier: Modifier = Modifier.weight(1f)

                        Row(modifier.fillMaxSize(1f)) {
                            Quadrant(backgroundColor = Color(0xFFEADDFF), title = "Text composable", description = "Displays text and follows the recommended Material Design guidelines.", modifier)
                            Quadrant(backgroundColor = Color(0xFFD0BCFF), title = "Image composable", description = "Creates a composable that lays out and draws a given Painter class object.", modifier)
                        }
                        Row(modifier.fillMaxSize(1f)) {
                            Quadrant(backgroundColor = Color(0xFFB69DF8), title = "Row composable", description = "A layout composable that places its children in a horizontal sequence.", modifier)
                            Quadrant(backgroundColor  = Color(0xFFF6EDFF), title = "Column composable", description = "A layout composable that places its children in a vertical sequence.", modifier)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Quadrant(backgroundColor: Color, title: String, description: String, modifier: Modifier) {
    Column(modifier = modifier.background(backgroundColor).padding(16.dp).fillMaxSize(1f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title, textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))
        Text(text = description, textAlign = TextAlign.Center)
    }

}

@Composable
fun ColumnWithLayout(content: @Composable ColumnScope.()->Unit) {
    Column (Modifier.fillMaxSize(1f)) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantPreview() {
    ComposeQuadrantTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ColumnWithLayout {
                val modifier: Modifier = Modifier.weight(1f)

                Row(modifier.fillMaxSize(1f)) {
                    Quadrant(backgroundColor = Color(0xFFEADDFF), title = "Text composable", description = "Displays text and follows the recommended Material Design guidelines.", modifier)
                    Quadrant(backgroundColor = Color(0xFFD0BCFF), title = "Image composable", description = "Creates a composable that lays out and draws a given Painter class object.", modifier)
                }
                Row(modifier.fillMaxSize(1f)) {
                    Quadrant(backgroundColor = Color(0xFFB69DF8), title = "Row composable", description = "A layout composable that places its children in a horizontal sequence.", modifier)
                    Quadrant(backgroundColor  = Color(0xFFF6EDFF), title = "Column composable", description = "A layout composable that places its children in a vertical sequence.", modifier)
                }
            }
        }
    }
}