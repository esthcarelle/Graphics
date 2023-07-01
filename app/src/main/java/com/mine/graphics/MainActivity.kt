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