import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainWindow() {
    Column(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 15.dp)
            .fillMaxHeight()
    ) {
        TopBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
        )
        MeasurementTab(
            modifier = Modifier
                .fillMaxHeight(0.9f)
                .fillMaxWidth()
        )
        BottomMenu(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        )
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Text(
            modifier = Modifier
                .weight(0.8f),
            text = "뇌파분석 프로그램",
            fontSize = 15.sp
        )
        Image(
            modifier = Modifier,
            imageVector = Icons.Default.Menu,
            contentDescription = "Logo image",
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
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
    Spacer(modifier = Modifier.height(7.dp))
}

@Composable
fun MeasurementTab(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            BrainWaveGraphsBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                title = "오른쪽 뇌파",
            )
            Spacer(modifier = Modifier.height(4.dp))
            BrainWaveGraphsBox(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                title = "왼쪽 뇌파",
            )
        }
    }
}


@Composable
fun BrainWaveGraphsBox(
    modifier: Modifier,
    title: String,
) {
    val selectedValue = remember { mutableStateOf("") }
    val label = listOf("전압 view", "대역 view", "Bar차트", "Pi차트")
    Surface(
        modifier = modifier,
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(23.dp)
                    .background(color = Color.Blue),
            ) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 5.dp),
                    text = title, color = Color.White,
                    fontSize = 8.sp
                )
            }
            Spacer(modifier = Modifier.height(3.dp))
            //안에 내용
            Row() {
                Column(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxHeight()
                ) {
                    //1번박스
                    Box(
                        modifier = Modifier
                            .fillMaxHeight(0.63f)
                            .fillMaxWidth()
                            .border(width = 1.dp, color = Color.DarkGray, shape = RectangleShape)
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    //2번박스
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .border(width = 1.dp, color = Color.DarkGray, shape = RectangleShape)

                    )
                }
                Spacer(modifier = Modifier.width(1.dp))
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    //3번 박스
                    Box(
                        modifier = Modifier
                            .fillMaxHeight(0.8f)
                            .fillMaxWidth()
                            .border(width = 1.dp, color = Color.DarkGray, shape = RectangleShape)
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    ) {
                        //4번 박스
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .border(width = 1.dp, color = Color.DarkGray, shape = RectangleShape)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        modifier = Modifier.scale(0.5f),
                                        selected = label.contains(selectedValue.value),
                                        onClick = {}
                                    )
                                    Text(modifier = Modifier, text = "전압 view", fontSize = 8.sp)
                                }
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        modifier = Modifier.scale(0.5f),
                                        selected = label.contains(selectedValue.value),
                                        onClick = {}
                                    )
                                    Text(text = "대역 view", fontSize = 8.sp)
                                }
                            }
                            //라디오 버튼 2개
                        }
                        Spacer(modifier = Modifier.width(1.dp))
                        //5번 박스
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(1f)
                                .border(width = 1.dp, color = Color.DarkGray, shape = RectangleShape)
                        ) {
                            //라디오 버튼 2개
                            Column {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        modifier = Modifier.scale(0.5f),
                                        selected = label.contains(selectedValue.value),
                                        onClick = {}
                                    )
                                    Text(text = "Bar차트", fontSize = 8.sp)
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    RadioButton(
                                        modifier = Modifier.scale(0.5f),
                                        selected = label.contains(selectedValue.value),
                                        onClick = {}
                                    )
                                    Text(text = "Pi차트", fontSize = 8.sp)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun BottomMenu(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        //시간
        Box(modifier = Modifier.weight(0.25f)) {
            MeasureTime()
        }
        //버튼 6개
        Box(modifier = Modifier.weight(0.6f)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ImageTextButton(
                    image = Icons.Default.Person,
                    text = "사용자선택",
                    onClick = {}
                )
                ImageTextButton(
                    image = Icons.Default.DateRange,
                    text = "파일",
                    onClick = {}
                )
                ImageTextButton(
                    image = Icons.Default.Place,
                    text = "측정",
                    onClick = {}
                )
                ImageTextButton(
                    image = Icons.Default.Menu,
                    text = "범위선택",
                    onClick = {}
                )
                ImageTextButton(
                    image = Icons.Default.Email,
                    text = "인쇄",
                    onClick = {}
                )
            }
        }
        ImageTextButton(
            image = Icons.Default.Close,
            text = "종료",
            onClick = {}
        )

    }
}

@Composable
fun MeasureTime(

) {
    val checkedState = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.8f)
            .border(width = 1.dp, color = Color.LightGray, shape = RectangleShape),
    ) {
        Column(modifier = Modifier, verticalArrangement = Arrangement.SpaceBetween) {
            Row {
                Checkbox(
                    modifier = Modifier
                        .size(7.dp),
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                )
                Text(text = "기본값 사용(120초)", fontSize = 8.sp)
            }
            Row {
                Text(text = "뇌파측정시간", fontSize = 8.sp)
                //시간 결정 뭔지 몰라
                Text(text = "   초", fontSize = 8.sp)
            }
            Row {
                Text(text = "진행", fontSize = 8.sp)
                LinearProgressIndicator(modifier = Modifier.weight(0.6f), progress = 0.7f)
                Text(text = "%", fontSize = 8.sp)
            }

        }
    }

}

@Composable
fun ImageTextButton(
    modifier: Modifier = Modifier,
    image: ImageVector,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.width(50.dp).height(50.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray, contentColor = Color.Black)
    ) {
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Image(modifier = Modifier.weight(0.9f), imageVector = image, contentDescription = "ImageTextButton")
            Text(text = text, fontSize = 8.sp, maxLines = 1)
        }
    }
}