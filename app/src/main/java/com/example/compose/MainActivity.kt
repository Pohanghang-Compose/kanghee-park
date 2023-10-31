package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ProfileCard()
                }
            }

        }
    }

    @Composable
    private fun ProfileCard() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color(0xffededed)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardTitle()
            ProfileImage()
            Nickname("Chun Bae")
            Grade()
            divider()
            Mbti()
            divider()
            Spacer(modifier = Modifier.height(250.dp))
            CardBottom()
        }
    }

    @Composable
    private fun CardBottom() {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xfff5cb36)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                imageVector = Icons.Default.ThumbUp,
                contentDescription = "Icon"
            )
            Text(
                text = "UNIVERSAL GUARDIANS NETWORK",
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    private fun divider() {
        Divider(
            color = Color(0xfff5cb36),
            thickness = 2.dp,
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 5.dp, bottom = 5.dp)
        )
    }

    @Composable
    private fun Grade() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
        ) {
            GradeTitle()
            GradeField(3)
        }
    }

    @Composable
    private fun GradeField(grade: Int) {
        Text(
            text = "$grade",
            color = Color(0xff635c51),
            modifier = Modifier.padding(start = 50.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    private fun GradeTitle() {
        Text(
            text = "Grade",
            color = Color(0xff635c51),
            modifier = Modifier.padding(start = 130.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    private fun Mbti() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            MbtiTitle()
            MbtiField("CUTE")
        }
    }

    @Composable
    private fun MbtiField(club: String) {
        Text(
            text = club,
            color = Color(0xff635c51),
            modifier = Modifier.padding(start = 50.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    private fun MbtiTitle() {
        Text(
            text = "MBTI",
            color = Color(0xff635c51),
            modifier = Modifier.padding(start = 130.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    private fun CardTitle() {
        Text(
            text = "IDENTIFICATION CARD",
            color = Color(0xffffffff),
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xfff5cb36))
                .padding(top = 16.dp, bottom = 16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }

    @Composable
    private fun ProfileImage() {
        Image(
            painter = painterResource(id = R.drawable.chunbae),
            contentDescription = "Profile",
            modifier = Modifier
                .size(170.dp)
                .padding(20.dp)
        )
    }

    @Composable
    private fun Nickname(name: String) {
        Text(
            text = name,
            color = Color(0xff635c51),
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
    }
}