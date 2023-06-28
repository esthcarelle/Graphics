package com.mine.graphics

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mine.graphics.ui.components.DecodedToken
import com.mine.graphics.ui.components.FacebookIcon
import com.mine.graphics.ui.components.GoogleIcon
import com.mine.graphics.ui.components.InstagramIcon
import com.mine.graphics.ui.components.MicrosoftIcon
import com.mine.graphics.ui.components.SpotifyIcon
import com.mine.graphics.ui.components.YoutubeIcon
import com.mine.graphics.ui.theme.GraphicsTheme
import java.io.UnsupportedEncodingException

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GraphicsTheme {
                try {
                    DecodedToken.getData()
//                    println("Check "+DecodedToken.getDecoded("R3JlYXQgam9iISAKCk5leHQgd2UndmUgaG9zdGVkIGEgSlNPTiBmaWxlIGF0IGF0IHRoaXMgdXJsOiBodHRwczovL2FwaS5qc29uYmluLmlvL3YzL2IvNjQ2YmVkMzI4ZTRhYTYyMjVlYTIyYTc5LiBZb3VyIGpvYiBpcyB0byB3cml0ZSBhIHNjcmlwdCB0bwpkb3dubG9hZCB0aGUgY29udGVudHMgb2YgdGhlIFVSTCAoaGludDogVGhlIFgtQUNDRVNTLUtFWSBpcyAkMmIkMTAkS2UxaXdpZUZPNy83cXNTS1UuR1lVLm9ZWFpNVzFFZUhyd2Q0eHg5eWxib0ppazVtc3RaazYpCnNvcnQgdGhlIGRhdGEgYnkgZWFjaCBlbGVtZW50cyAnYmFyJyBrZXkKZmlsdGVyIG91dCBlbGVtZW50cyB3aGVyZSAnYmF6JyBpcyBub3QgZGl2aXNpYmxlIGJ5IDMKY29uY2F0ZW5hdGUgZWFjaCBlbGVtZW50cyAnZm9vJyB2YWx1ZQoKRG8gZWFjaCBvZiB0aGVzZSBzdGVwcyB0byByZXZlYWwgdGhlIGluc3RydWN0aW9ucyBmb3IgdGhlIGZpbmFsIHBhcnQuIFJlbWVtYmVyIHRvIHNob3cgeW91ciB3b3JrIQ=="))
                } catch (e: UnsupportedEncodingException) {
                    println("Exception"+ e.message)
                    throw RuntimeException(e)
                }
                println("hey hey")
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black),
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        GoogleIcon()
                        FacebookIcon()
                        InstagramIcon()
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        YoutubeIcon()
                        SpotifyIcon()
                        MicrosoftIcon()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GraphicsTheme {
        Greeting("Android")
    }
}