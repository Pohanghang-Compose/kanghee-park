package com.example.compose.presentation

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
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.compose.R
import com.example.compose.data.Screen
import com.example.compose.data.Student
import com.example.compose.ui.theme.PohangYellow

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
                PohangYellow,
                contentColor = Color.White
            ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp
        )
    ) {
        Text(text = Screen.Profile.name)
    }
}

@Composable
private fun FriendListItem(student: Student) {
    Card(
        Modifier
            .padding(12.dp)
            .border(width = 4.dp, color = PohangYellow)
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
                contentDescription = stringResource(id = R.string.profile_description),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .padding(10.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "${stringResource(id = R.string.friendlist_card_id)}: ${student.id}",
                    fontSize = 18.sp
                )
                Text(
                    text = "${stringResource(id = R.string.friendlist_card_name)}: ${student.name}",
                    fontSize = 18.sp
                )
            }
        }
    }
}