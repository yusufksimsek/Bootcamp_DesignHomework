package com.example.composebootcamp_designhomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebootcamp_designhomework.ui.theme.AlternativeColor
import com.example.composebootcamp_designhomework.ui.theme.AlternativeDarkColor
import com.example.composebootcamp_designhomework.ui.theme.ComposeBootcamp_DesignHomeworkTheme
import com.example.composebootcamp_designhomework.ui.theme.MainColor
import com.example.composebootcamp_designhomework.ui.theme.MainDarkColor
import com.example.composebootcamp_designhomework.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBootcamp_DesignHomeworkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NewsPage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsPage(darkTheme: Boolean = isSystemInDarkTheme()) {
    Scaffold(topBar = {
        TopAppBar(
            title = { TopAppBarTitle(content = stringResource(id = R.string.topAppBarTitle)) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = if (darkTheme) MainDarkColor else MainColor,
                titleContentColor = White
            ),
            actions = {
                ReIcon(id = R.drawable.bookmark_icon)
                ReIcon(id = R.drawable.share_icon)
                ReIcon(id = R.drawable.world_icon)
            }
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NewsTitle(content = stringResource(id = R.string.newsTitle))
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp)
                    .height(48.dp)
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (darkTheme) MainDarkColor else MainColor,
                        contentColor = White
                    ),
                    shape = androidx.compose.foundation.shape.AbsoluteCutCornerShape(5.dp),
                    modifier = Modifier
                        .weight(50f)
                        .fillMaxHeight()
                ) {
                    ButtonTitle(content = stringResource(id = R.string.button1Title))
                }
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (darkTheme) AlternativeDarkColor else AlternativeColor,
                        contentColor = White
                    ),
                    shape = androidx.compose.foundation.shape.AbsoluteCutCornerShape(5.dp),
                    modifier = Modifier
                        .weight(50f)
                        .fillMaxHeight()
                ) {
                    ButtonTitle(content = stringResource(id = R.string.button2Title))
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 12.dp)
            ) {
                CategoryTitle(content = stringResource(id = R.string.categoryTitle))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Article(content = stringResource(id = R.string.articleCrypto))
                    Article(content = stringResource(id = R.string.articleDate))
                }
                Article(content = stringResource(id = R.string.articleNews))
            }
        }
    }
}

@Composable
fun ReIcon(id:Int){
    IconButton(onClick = { }) {
        Icon(
            painter = painterResource(id = id),
            contentDescription = "",
            tint = White
        )
    }
}

@Composable
fun Article(content: String) {
    Text(
        text = content,
        fontFamily = FontFamily(Font(R.font.robotofont))
    )
}

@Composable
fun TopAppBarTitle(content: String) {
    Text(
        text = content,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.myfont))
    )
}

@Composable
fun ButtonTitle(content: String) {
    Text(
        text = content,
        fontSize = 16.sp
    )
}

@Composable
fun CategoryTitle(content: String, darkTheme: Boolean = isSystemInDarkTheme()) {
    Text(
        text = content,
        color = if (darkTheme) AlternativeDarkColor else AlternativeColor,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.robotofont))
    )
}

@Composable
fun NewsTitle(content: String, modifier: Modifier = Modifier) {
    Text(
        text = content,
        modifier = modifier.padding(vertical = 16.dp, horizontal = 6.dp),
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.myfont))
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBootcamp_DesignHomeworkTheme {
        NewsPage()
    }
}