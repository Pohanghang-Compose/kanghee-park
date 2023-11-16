package com.example.compose.presentation

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.compose.R
import com.example.compose.data.Screen
import com.example.compose.ui.theme.PohangAshBrown
import com.example.compose.ui.theme.PohangGray
import com.example.compose.ui.theme.PohangYellow

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
                .background(color = PohangGray),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardTitle()
            ProfileImage()
            Nickname(stringResource(id = R.string.main_name_defalut))
            Grade()
            DividerField()
            Mbti()
            DividerField()
            ButtonToFriendList(navController)
            ButtonToSurvey(navController)
            Spacer(modifier = Modifier.height(150.dp))
            CardBottom()
        }
    }
}

@Composable
private fun ButtonToFriendList(navController: NavHostController) {
    Button(
        onClick = {
            navController.navigate(Screen.FriendList.name)
        },
        colors = ButtonDefaults
            .buttonColors(
                PohangYellow,
                contentColor = Color.White
            ),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
    ) {
        Text(text = "Friend List")

    }
}

@Composable
private fun ButtonToSurvey(navController: NavHostController) {
    Button(
        onClick = {
            navController.navigate(Screen.Survey.name)
        },
        colors = ButtonDefaults
            .buttonColors(
                PohangYellow,
                contentColor = Color.White
            ),
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 0.dp)
    ) {
        Text(text = "Survey")

    }
}

@Composable
private fun CardBottom() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(PohangYellow),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(40.dp),
            imageVector = Icons.Default.ThumbUp,
            contentDescription = stringResource(id = R.string.icon_description)
        )
        Text(
            text = stringResource(id = R.string.main_card_agency),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun DividerField() {
    Divider(
        color = PohangYellow,
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
        color = PohangAshBrown,
        modifier = Modifier.padding(start = 50.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun GradeTitle() {
    Text(
        text = stringResource(id = R.string.main_grade_title),
        color = PohangAshBrown,
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
        MbtiField(stringResource(id = R.string.main_mbti_defalut))
    }
}

@Composable
private fun MbtiField(club: String) {
    Text(
        text = club,
        color = PohangAshBrown,
        modifier = Modifier.padding(start = 50.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun MbtiTitle() {
    Text(
        text = stringResource(id = R.string.main_mbti_title),
        color = PohangAshBrown,
        modifier = Modifier.padding(start = 130.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun CardTitle() {
    Text(
        text = stringResource(id = R.string.main_card_title),
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = PohangYellow)
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
        contentDescription = stringResource(id = R.string.profile_description),
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
        color = PohangAshBrown,
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    )
}