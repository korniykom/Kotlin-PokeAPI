import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.korniykom.pokeapi.R

@Composable
fun ReloadButton(modifier: Modifier = Modifier, onClick: () -> Unit) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp)
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        colorResource(R.color.red_1), colorResource(R.color.red_2)
                    )
                ), shape = ButtonDefaults.shape
            )
    ) {
        Button(
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Reload Pokemons!", color = Color.White)
        }
    }
}
