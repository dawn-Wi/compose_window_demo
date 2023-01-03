import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import jdk.jfr.Enabled
import org.w3c.dom.Text

@Composable
@Preview
fun App() {

    MaterialTheme {
        Column(modifier = Modifier.padding(start = 20.dp, end = 5.dp)) {
            Row(
                modifier = Modifier.align(Alignment.End),
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Image(modifier = Modifier, imageVector = Icons.Default.Add, contentDescription = "Minimum Size")
                Image(modifier = Modifier, imageVector = Icons.Default.Menu, contentDescription = "Maximum Size")
                Image(modifier = Modifier, imageVector = Icons.Default.Close, contentDescription = "Close page")
            } //아이콘 3개
            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = "이음숲 뇌파측정",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            ) //Title
            Spacer(modifier = Modifier.height(40.dp))
            LoginCard(
                modifier = Modifier,
                confirmOnClick = {},
                cancelOnClick = {},
            )
            Spacer(modifier = Modifier.height(75.dp))
            Row(modifier = Modifier.padding(end = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                Button(
                    modifier = Modifier.weight(1f)
                        .align(Alignment.CenterVertically),
                    onClick = {},
                    enabled = false,
                ) {
                    Column {
                        Image(
                            modifier = Modifier.size(150.dp).padding(top = 20.dp),
                            imageVector = Icons.Default.Face,
                            contentDescription = null
                        )
                        Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = "뉴로스펙 측정")
                    }
                }
                Button(
                    modifier = Modifier.weight(1f)
                        .align(Alignment.CenterVertically),
                    onClick = {},
                    enabled = false,
                ) {
                    Column {
                        Image(
                            modifier = Modifier.size(150.dp).padding(top = 20.dp),
                            imageVector = Icons.Default.Place,
                            contentDescription = null,
                        )
                        Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = "뇌파분석")
                    }
                }
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        SecondView()
    }
}


@Composable
fun LoginCard(
    modifier: Modifier,
    confirmOnClick: () -> Unit,
    cancelOnClick: () -> Unit,
    confirmButtonEnabled: Boolean = true,
    cancelButtonEnabled: Boolean = true,
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                modifier = modifier
                    .size(130.dp),
                imageVector = Icons.Default.Person,
                contentDescription = "Login Image",
            )// 이미지
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                modifier = modifier.padding(end = 20.dp).align(Alignment.CenterVertically),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Row(modifier = modifier.align(Alignment.End)) {
                    Text(
                        modifier = modifier.align(Alignment.CenterVertically).width(70.dp),
                        text = "사용자 :"
                    )
                    TextField(
                        modifier = modifier
                            .height(30.dp)
                            .width(200.dp),
                        value = "",
                        onValueChange = {},
                    )
                }
                Row(modifier = modifier.align(Alignment.End)) {
                    Text(
                        modifier = modifier.align(Alignment.CenterVertically).width(70.dp),
                        text = "암호 :"
                    )
                    TextField(
                        modifier = modifier
                            .height(30.dp)
                            .width(200.dp),
                        value = "",
                        onValueChange = {},
                    )
                }
            } //textField 2개
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = modifier.align(Alignment.CenterHorizontally),
            horizontalArrangement = Arrangement.spacedBy(60.dp)
        ) {
            Button(
                modifier = modifier
                    .widthIn(min = 100.dp, max = 150.dp),
                onClick = confirmOnClick,
                enabled = confirmButtonEnabled,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray, contentColor = Color.Black),
                ) {
                Text(text = "확인", fontWeight = FontWeight.Bold)
            } // 확인
            Button(
                modifier = modifier
                    .widthIn(min = 100.dp, max = 150.dp),
                onClick = cancelOnClick,
                enabled = cancelButtonEnabled,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray, contentColor = Color.Black)
            ) {
                Text(text = "취소", fontWeight = FontWeight.Bold)
            } // 취소
        }
    }
}

