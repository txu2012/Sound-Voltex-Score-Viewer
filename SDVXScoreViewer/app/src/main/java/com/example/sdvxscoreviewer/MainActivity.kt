package com.example.sdvxscoreviewer

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.widget.Button
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sdvxscoreviewer.ui.theme.SDVXScoreViewerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /*super.onCreate(savedInstanceState)
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

            println("Test Message")

            val xmlFile = assets.open("music_db.xml")
            val SongExtractor = SongExtract()
            SongExtractor.ExtractXml(xmlFile)
            var songList = SongExtractor.GetSongList()

            Log.d("Xml","Finished")
            Log.d("SongList Size", songList.size.toString())

            DisplaySongs(songList)
        }*/
        //setContentView(R.layout.activity_main)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize data.
        //val myDataset = Datasource().loadAffirmations()
        val xmlFile = assets.open("music_db.xml")
        val SongExtractor = SongExtract()
        SongExtractor.ExtractXml(xmlFile)
        var songList = SongExtractor.GetSongList()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        //recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(color = Color.White) {
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

@Composable
fun DisplaySongs(songs: ArrayList<Song>, modifier: Modifier = Modifier) {
    Column (modifier = modifier.padding(start = 10.dp, top = 110.dp)) {
        for (song in songs) {
            Row {
                Text(
                    modifier = modifier.padding(top = 10.dp, start = 5.dp),
                    text = "${song.Id}",
                    fontSize = 15.sp,
                    lineHeight = 35.sp
                )
                Text(
                    modifier = modifier.padding(top = 10.dp, start = 5.dp),
                    text = "${song.Version}",
                    fontSize = 15.sp,
                    lineHeight = 35.sp
                )
                Text(
                    modifier = modifier.padding(top = 10.dp, start = 5.dp),
                    text = "${song.Name}",
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