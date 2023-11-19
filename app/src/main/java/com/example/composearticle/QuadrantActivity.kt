package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composearticle.ui.theme.ComposeArticleTheme

data class Quadrant(val title: String, val message: String, val color: Color, val alignment: Alignment)

class QuadrantActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantPreview()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(quadrants: Array<Quadrant>, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        quadrants.forEach { quadrant ->
            Surface(
                color = quadrant.color,
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .align(quadrant.alignment)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier
                        .padding(16.dp)
                ) {
                    Text(
                        text = quadrant.title,
                        fontWeight = FontWeight.Bold,
                        modifier = modifier
                            .padding(bottom = 16.dp)
                    )
                    Text(
                        text = quadrant.message,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    val quadrants = arrayOf(
        Quadrant(
            title = stringResource(R.string.quadrant1_title_quadrant_activity),
            message = stringResource(R.string.quadrant1_message_quadrant_activity),
            color = Color(0xFFEADDFF),
            alignment = Alignment.TopStart
        ),
        Quadrant(
            title = stringResource(R.string.quadrant2_title_quadrant_activity),
            message = stringResource(R.string.quadrant2_message_quadrant_activity),
            color = Color(0xFFD0BCFF),
            alignment = Alignment.TopEnd
        ),
        Quadrant(
            title = stringResource(R.string.quadrant3_title_quadrant_activity),
            message = stringResource(R.string.quadrant3_message_quadrant_activity),
            color = Color(0xFFB69DF8),
            alignment = Alignment.BottomStart
        ),
        Quadrant(
            title = stringResource(R.string.quadrant4_title_quadrant_activity),
            message = stringResource(R.string.quadrant4_message_quadrant_activity),
            color = Color(0xFFF6EDFF),
            alignment = Alignment.BottomEnd
        )
    )
    ComposeArticleTheme {
        ComposeQuadrant(quadrants = quadrants)
    }
}