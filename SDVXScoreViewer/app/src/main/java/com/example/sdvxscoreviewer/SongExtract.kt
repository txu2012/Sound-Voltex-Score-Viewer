package com.example.sdvxscoreviewer

import java.util.List;
import android.app.DownloadManager.Query
import android.graphics.Movie
import android.provider.DocumentsContract.Root
import android.util.Log
import org.xml.sax.InputSource
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.StringReader


enum class InfDifficulty(val value: Int) {
    NA(0),
    Inf(2),
    Grv(3),
    Hvn(4),
    Vvd(5),
    Xcd(6)
}

data class Song(
    var Id: Int,
    var Version: Int? = 0,
    var InfVersion: Int? = 0,
    var Name: String? = "",
    var AsciiName: String? = "",
    var Artist: String? = "",
    var Illustrator: String? = "",
    var Effector: String? = "",
    var SongJacket: String? = "",
    var DifficultyMap: IntArray? = intArrayOf(1, 2, 3),
    var MinBpm: Int? = 0,
    var MaxBpm: Int? = 0,
    var Volume: Int? = 0,
    var Label: String? = ""
)

class SongExtract {

    private var songs = ArrayList<Song>()
    private var song: Song? = null
    fun GetSongList(): ArrayList<Song>
    {
        return songs
    }

    fun ExtractXml(inputStream: InputStream)
    {
        //val inputStream = assets.open("music_db.xml")
        //val xmlFile = File("./music_db.xml");
        //val xmlInput = InputSource(StringReader(xmlFile.readText()))
        //val parserFactory: XmlPullParserFactory = XmlPullParserFactory.newInstance()
        //val parser: XmlPullParser = parserFactory.newPullParser()
        //parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, true)
        //parser.setInput(inputStream, null)
        try {
            Log.d("Xml","Start")
            val factory = XmlPullParserFactory.newInstance()
            factory.isNamespaceAware = true

            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)

            var eventType = parser.eventType

            var song: Song? = null
            var xmlText: String? = null
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tag = parser.name
                when (eventType) {
                    XmlPullParser.START_TAG -> {
                        if (tag.equals("song", ignoreCase = true)) {
                            song = Song(1)
                        }
                    }
                    XmlPullParser.TEXT -> xmlText = parser.text
                    XmlPullParser.END_TAG -> {
                        if (tag.equals("id", ignoreCase = true)) {
                            song!!.Id = Integer.parseInt(xmlText)
                        }
                        else if (tag.equals("version", ignoreCase = true)) {
                            song!!.Version = Integer.parseInt(xmlText)
                        }
                        else if (tag.equals("infVer", ignoreCase = true)) {
                            song!!.InfVersion = Integer.parseInt(xmlText)
                        }
                        else if (tag.equals("name", ignoreCase = true)) {
                            song!!.Name = xmlText
                        }
                        else if (tag.equals("asciiName", ignoreCase = true)) {
                            song!!.AsciiName = xmlText
                        }
                        else if (tag.equals("artist", ignoreCase = true)) {
                            song!!.Artist = xmlText
                        }
                        else if (tag.equals("illustrator", ignoreCase = true)) {
                            song!!.Illustrator = xmlText
                        }
                        else if (tag.equals("effector", ignoreCase = true)) {
                            song!!.Effector = xmlText
                        }
                        else if (tag.equals("jacket", ignoreCase = true)) {
                            song!!.SongJacket = xmlText
                        }
                        else if (tag.equals("difficulty", ignoreCase = true)) {
                            song!!.DifficultyMap = intArrayOf(0, 1, 2, 3)
                        }
                        else if (tag.equals("bpm_min", ignoreCase = true)) {
                            song!!.MinBpm = Integer.parseInt(xmlText)
                        }
                        else if (tag.equals("bpm_max", ignoreCase = true)) {
                            song!!.MaxBpm = Integer.parseInt(xmlText)
                        }
                        else if (tag.equals("volume", ignoreCase = true)) {
                            song!!.Volume = Integer.parseInt(xmlText)
                        }
                        else if (tag.equals("label", ignoreCase = true)) {
                            song!!.Label = xmlText
                        }
                    }
                    else -> {}
                }
                Log.d("Xml Tag","$tag")
                Log.d("Xml Text","$xmlText")
                eventType = parser.next()
            }
        } catch (e: XmlPullParserException) {
            Log.d("Xml","Parse Exception")
            e.printStackTrace()
        } catch (e: IOException) {
            Log.d("Xml","Io Exception")
            e.printStackTrace()
        }
    }
}

/*
data class Song(
    var Id: Int,
    var Version: Int? = 0,
    var InfVersion: Int? = 0,
    var Name: String? = "",
    var AsciiName: String? = "",
    var Artist: String? = "",
    var Illlustration: String? = "",
    var Effector: String? = "",
    var SongJacket: String? = "",
    var DifficultyMap: IntArray? = intArrayOf(1, 2, 3),
    var MinBpm: Int? = 0,
    var MaxBpm: Int? = 0,
    var Volume: Int? = 0,
    var Label: String? = ""
)*/
