package com.korniykom.getblock.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.korniykom.getblock.R
import com.korniykom.getblock.ui.components.LogoImage
import com.korniykom.getblock.ui.components.LogoWord

@Composable
fun GetBlockApp(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xffd43bd4),
                        Color(0xff3071ab),
                        Color(0xff00e8b5))
                )
            )
    ) {
        Column(modifier = modifier.padding(top = 30.dp, start = 20.dp, end = 20.dp, bottom = 50.dp)) {
            TopBar(modifier = modifier)
//            Text(
//                text = stringResource(R.string.home_screen_title)
//            )
            Row(modifier = modifier) {}
        }
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogoWord()
        LogoImage(modifier = modifier
            .height(40.dp)
            .width(40.dp)
            .clip(RoundedCornerShape(10.dp))
        )
    }
}