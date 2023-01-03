import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@Composable
fun SecondView() {

    MaterialTheme {
        Column {
            //Title + image
            Row {
                Text(
                    modifier = Modifier
                        .weight(0.8f),
                    text = "뇌파분석 프로그램"
                )
                Image(
                    modifier = Modifier,
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Logo image",
                )
            }
            //label
            Row {
                ClickableText(
                    modifier = Modifier,
                    text = AnnotatedString("측정"),
                    onClick = {}
                )
                ClickableText(
                    modifier = Modifier,
                    text = AnnotatedString("설정"),
                    onClick = {}
                )
            }
            Divider(color = Color.LightGray, thickness = 2.dp)



            //content
            //bottom menu
        }
    }
}

@Composable
fun measurement(){

}