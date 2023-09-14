package com.example.sdvxscoreviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.sdvxscoreviewer.ui.theme.SDVXScoreViewerTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SDVXScoreViewerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("犬わん")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.Cyan) {
        Text(
            text = "Welcome to the SDVX Score Viewer: $name!",
            modifier = modifier.padding(24.dp)
        )
    }
}

@Composable
fun TestFunction(desc: String, modifier: Modifier = Modifier) {
    Row {
        Column {
            Text("SDVX" ,
                modifier = modifier.padding(start = 100.dp, top = 50.dp),
                fontSize = 35.sp,
                lineHeight = 35.sp)
        }
        Column {
            Text("Scores",
                modifier = modifier.padding(top = 50.dp),
                fontSize = 35.sp,
                lineHeight = 35.sp)
        }
    }
    Row {
        Text("$desc",
            modifier = modifier.padding(start = 10.dp, top = 90.dp),
            fontSize = 15.sp,
            lineHeight = 15.sp
        )
    }
}

@Composable
fun ArrayOfText(list: Array<String>, modifier: Modifier = Modifier) {
    Column (modifier = modifier.padding(start = 10.dp, top = 110.dp)) {
        for (text in list) {
            Row {
                Text(
                    modifier = modifier.padding(top = 10.dp),
                    text = "$text",
                    fontSize = 15.sp,
                    lineHeight = 35.sp
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    SDVXScoreViewerTheme {
        Greeting("犬わん")
        TestFunction(desc = "Description")
        ArrayOfText(list = arrayOf("Text1","Text2","Text3","Text4"))
    }
}