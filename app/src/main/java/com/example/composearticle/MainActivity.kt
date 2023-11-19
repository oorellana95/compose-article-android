package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

data class Quadrant(val title: String, val message: String, val color: Color, val alignment: Alignment)

class MainActivity : ComponentActivity() {
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
fun ComposeArticle(title: String, messages: Array<String>, wallpaper: Painter, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ){
        Image(
            painter = wallpaper,
            contentDescription = "wallpaper",
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )

        messages.forEach { message ->
            Text(
                text = message,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}

@Composable
fun TaskManager(mainMessage: String, secondaryMessage: String, image: Painter, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Image(
            painter = image,
            contentDescription = "image",
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = mainMessage,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = secondaryMessage,
            fontSize = 16.sp
        )
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
fun ComposeArticlePreview() {
    val title = "Jetpack Compose tutorial"
    val messages = arrayOf(
        "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
        "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
    )
    val wallpaper = painterResource(R.drawable.bg_compose_background)
    ComposeArticleTheme {
        ComposeArticle(title = title, messages = messages, wallpaper = wallpaper)
    }
}


@Preview(showBackground = true)
@Composable
fun TaskManagerPreview() {
    val mainMessage = "All tasks completed"
    val secondaryMessage = "Nice work!"
    val image = painterResource(R.drawable.ic_task_completed)
    ComposeArticleTheme {
        TaskManager(mainMessage = mainMessage, secondaryMessage = secondaryMessage, image = image)
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    val quadrants = arrayOf(
        Quadrant(
            title = "Text composable",
            message = "Displays text and follows the recommended Material Design guidelines.",
            color = Color(0xFFEADDFF),
            alignment = Alignment.TopStart
        ),
        Quadrant(
            title = "Image composable",
            message = "Creates a composable that lays out and draws a given Painter class object.",
            color = Color(0xFFD0BCFF),
            alignment = Alignment.TopEnd
        ),
        Quadrant(
            title = "Row composable",
            message = "A layout composable that places its children in a horizontal sequence.",
            color = Color(0xFFB69DF8),
            alignment = Alignment.BottomStart
        ),
        Quadrant(
            title = "Column composable",
            message = "A layout composable that places its children in a vertical sequence.",
            color = Color(0xFFF6EDFF),
            alignment = Alignment.BottomEnd
        )
    )
    ComposeArticleTheme {
        ComposeQuadrant(quadrants = quadrants)
    }
}