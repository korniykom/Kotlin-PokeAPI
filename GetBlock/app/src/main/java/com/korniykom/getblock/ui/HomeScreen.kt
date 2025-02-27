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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.korniykom.getblock.R
import com.korniykom.getblock.ui.components.TopBar
import androidx.lifecycle.viewmodel.compose.viewModel
import com.korniykom.getblock.ui.components.LogoImage
import com.korniykom.getblock.ui.theme.GetBlockTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    getBlockViewModel: GetBlockViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val uiState by getBlockViewModel.uiState.collectAsState()

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
        Column(modifier = modifier.padding(top = 30.dp, start = 16.dp, end = 16.dp, bottom = 50.dp)) {
            TopBar(modifier = modifier)
            Text(
                fontWeight = FontWeight.W400,
                fontSize = 26.sp,
                color = Color.White,
                text = stringResource(R.string.home_screen_title)
            )
            Row(modifier = modifier) {
                SearchBar(
                    query = uiState.searchQuery,
                    onQueryChange = { getBlockViewModel.updateSearchQuery(it)},
                    onSearch = {},
                    active = false,
                    onActiveChange = {},
                    placeholder = {
                        Text(
                            text = "Search transactions, blocks, programs and tokens",
                        )
                    },
                    shape = RoundedCornerShape(12.dp) ,
                    modifier = modifier
                        .fillMaxWidth()

                ) { }
            }
            Row(modifier = modifier
                .padding(top = 24.dp),
                ) {

                LogoImage(
                        modifier = modifier
                            .height(24.dp)
                            .width(24.dp)
                            .clip(CircleShape)
                            .padding(0.dp)
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    text = "$00.00",
                    color = Color.White
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    text = "|",
                    color = Color.White
                )
                Spacer(modifier = modifier.width(8.dp))
                Text(
                    text = "Avg Fee: 0.0000000",
                    color = Color.White

                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun HomeScreenPreview() {
    GetBlockTheme {
        HomeScreen()
    }
}