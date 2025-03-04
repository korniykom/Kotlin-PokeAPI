package com.korniykom.pokeapi.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.korniykom.pokeapi.R

@Composable
fun SortButton(
    modifier: Modifier = Modifier, onClick: () -> Unit, text: String = "Empty"
) {
    OutlinedButton(modifier = modifier

        .height(60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            1.dp, Brush.verticalGradient(
                colors = listOf(
                    colorResource(R.color.red_1), colorResource(R.color.red_2)
                )
            )
        ),
        onClick = { onClick() }) {
        Text(
            text = text, color = colorResource(R.color.red_1_light),
            fontWeight = FontWeight.ExtraBold,

            )
    }
}
