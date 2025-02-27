package com.korniykom.getblock.ui.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.korniykom.getblock.R

@Composable
fun LogoWord(modifier: Modifier = Modifier) {
        Image(
            painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = modifier
        )
}