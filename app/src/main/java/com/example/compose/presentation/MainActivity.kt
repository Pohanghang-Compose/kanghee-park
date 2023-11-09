package com.example.compose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.compose.R
import com.example.compose.data.Screen
import com.example.compose.data.Student
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = Screen.Profile.name) {
                    composable(Screen.Profile.name) { MainScreen(navController) }
                    composable(Screen.FriendList.name) { FriendListScreen(navController) }
                }
            }
        }
    }

    @Composable
    fun MainScreen(navController: NavHostController) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
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
                DividerField()
                Mbti()
                DividerField()
                ButtonToFriendList(navController)
                Spacer(modifier = Modifier.height(200.dp))
                CardBottom()
            }
        }
    }

    @Composable
    private fun ButtonToFriendList(navController: NavHostController) {
        Button(
            onClick = {
                navController.navigate("friendList")
            },
            colors = ButtonDefaults
                .buttonColors(
                    Color(0xfff5cb36),
                    contentColor = Color.White
                ),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
        ) {
            Text(text = "Friend List")

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
    private fun DividerField() {
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
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://archeage.xlgames.com/www/attachments/8a948b8385c779ae01860cf2e6af0070")
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = R.drawable.chunbae),
            contentDescription = "Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(170.dp)
                .padding(20.dp)
                .clip(CircleShape)
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

    @Composable
    fun FriendListScreen(navController: NavHostController) {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ButtonToProfile(navController)
                LazyColumn() {
                    item {
                        FriendListItem(
                            Student(
                                0,
                                "박강희",
                                "https://archeage.xlgames.com/www/attachments/8a948b8385c779ae01860cf2e6af0070"
                            )
                        )
                        FriendListItem(
                            Student(
                                1,
                                "박동민",
                                "https://previews.123rf.com/images/piyato/piyato1204/piyato120400073/13122103-%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD%EC%97%90-%EA%B3%84%EB%9E%80-%EC%B4%88%EB%B0%A5.jpg"
                            )
                        )
                        FriendListItem(
                            Student(
                                2,
                                "최유리",
                                "https://image.chukouplus.com/upload/C_2687/file/20221224/5dbf580081511e34346c8422852e236c.jpg?x-oss-process=image/format,webp,image/resize,m_pad,h_450,w_600,color_FFFFFF"
                            )
                        )
                        FriendListItem(
                            Student(
                                3,
                                "조관희",
                                "https://pbs.twimg.com/media/EXfa87lU4AEG3rL.png"
                            )
                        )
                        FriendListItem(
                            Student(
                                4,
                                "이태희",
                                "https://onimg.nate.com/orgImg/at/2010/07/28/382320(0)-340317_81943.jpg"
                            )
                        )
                        FriendListItem(
                            Student(
                                5,
                                "이삭",
                                "https://cdn.ikpnews.net/news/photo/202208/48106_33583_5048.jpg"
                            )
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun ButtonToProfile(navController: NavHostController) {
        Button(
            onClick = {
                navController.navigate(Screen.Profile.name)
            },
            colors = ButtonDefaults
                .buttonColors(
                    Color(0xfff5cb36),
                    contentColor = Color.White
                ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp
            )
        ) {
            Text(text = "Profile List")
        }
    }

    @Composable
    private fun FriendListItem(student: Student) {
        Card(
            Modifier
                .padding(12.dp)
                .border(width = 4.dp, color = Color(0xfff5cb36))
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(student.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = "학번: ${student.id}", fontSize = 18.sp)
                    Text(text = "이름: ${student.name}", fontSize = 18.sp)
                }
            }
        }
    }
}
