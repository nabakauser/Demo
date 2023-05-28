package com.example.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    private val viewModel: EmergencyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SessionPreviewScreen() {
//    SessionDetailComponent(
//        "05", "10", "02", "03", {}, {},"",{}
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun FMY() {
//    FindMyChildComponent {}
//}
//
//@Preview(showBackground = true)
//@Composable
//fun QJ() {
//    QuickJumpComponentItem(
//        icon = painterResource(id = R.drawable.ic_attendance_report),
//        text = "Courses",
//        onIconClicked = {}
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun QJC() {
//    QuickJumpComponent(
//        {}, {}, {}, {}, {}
//    )
//}

//@Composable
//fun SessionDetailComponent(
//    completedSessions: String,
//    totalSessions: String,
//    absentSessionCount: String,
//    presentSessionCount: String,
//    onPreviousDateClicked: (String) -> Unit,
//    onNextDateClicked: (String) -> Unit,
//    selectedDate: String,
//    onDateFromCalendarClicked: (String) -> Unit,
//) {
//    Card(
//        modifier = Modifier.padding(5.dp),
//        shape = RoundedCornerShape(10.dp),
//        border = BorderStroke(1.dp, Color.LightGray),
//        colors = CardDefaults.cardColors(Color.White)
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp)
//                .background(Color.White)
//        ) {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically,
//            ) {
//                Icon(
//                    modifier = Modifier.clickable {
//                        onPreviousDateClicked(selectedDate)
//                    },
//                    tint = colorResource(id = R.color.digi_blue),
//                    painter = painterResource(id = R.drawable.ic_previous_arrow),
//                    contentDescription = "Previous Arrow"
//                )
//                Row {
//                    Text(
//                        style = TextStyle(
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold
//                        ),
//                        color = Color.DarkGray,
//                        text = "Today Session"
//                    )
//                    Spacer(modifier = Modifier.padding(5.dp))
//                    Icon(
//                        modifier = Modifier.clickable {
//                            onDateFromCalendarClicked(selectedDate)
//                        },
//                        painter = painterResource(id = R.drawable.ic_calendar),
//                        tint = Color.DarkGray,
//                        contentDescription = null
//                    )
//                }
//                Icon(
//                    modifier = Modifier.clickable {
//                        onNextDateClicked(selectedDate)
//                    },
//                    tint = colorResource(id = R.color.digi_blue),
//                    painter = painterResource(id = R.drawable.ic_next_arrow),
//                    contentDescription = "Next Arrow"
//                )
//            }
//            DividerLine()
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(5.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Row(
//                    horizontalArrangement = Arrangement.Start,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        tint = colorResource(id = R.color.digi_blue),
//                        painter = painterResource(id = R.drawable.ic_session),
//                        contentDescription = null
//                    )
//                    Spacer(modifier = Modifier.padding(start = 5.dp))
//                    Text(
//                        style = TextStyle(
//                            fontSize = 15.sp,
//                        ),
//                        color = colorResource(id = R.color.grey_new),
//                        text = "No. of Sessions"
//                    )
//                }
//                Text(
//                    style = TextStyle(
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight.Bold
//                    ),
//                    color = Color.DarkGray,
//                    text = stringResource(
//                        id = R.string.no_of_sessions,
//                        completedSessions,
//                        totalSessions
//                    )
//                )
//            }
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                val progressValue =
//                    (completedSessions.toDouble().div(totalSessions.toDouble())).toFloat()
//                LinearProgressIndicator(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(5.dp)
//                        .clip(RoundedCornerShape(30.dp))
//                        .height(10.dp),
//                    color = colorResource(R.color.green),
//                    trackColor = colorResource(R.color.grey_200),
//                    progress = progressValue
//                )
//            }
//            DividerLine()
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(5.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Row(
//                    horizontalArrangement = Arrangement.Start,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        tint = Color.Red,
//                        painter = painterResource(id = R.drawable.ic_absent_count),
//                        contentDescription = null
//                    )
//                    Spacer(modifier = Modifier.padding(start = 5.dp))
//                    Text(
//                        style = TextStyle(
//                            fontSize = 15.sp,
//                        ),
//                        color = colorResource(id = R.color.grey_new),
//                        text = "Absent Sessions"
//                    )
//                }
//                Text(
//                    style = TextStyle(
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight.Bold
//                    ),
//                    color = Color.DarkGray,
//                    text = absentSessionCount
//                )
//            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(5.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Row(
//                    horizontalArrangement = Arrangement.Start,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        tint = Color.Green,
//                        painter = painterResource(id = R.drawable.ic_present_count),
//                        contentDescription = null
//                    )
//                    Spacer(modifier = Modifier.padding(start = 5.dp))
//                    Text(
//                        style = TextStyle(
//                            fontSize = 15.sp,
//                        ),
//                        color = colorResource(id = R.color.grey_new),
//                        text = "Present Sessions"
//                    )
//                }
//                Text(
//                    style = TextStyle(
//                        fontSize = 18.sp,
//                        fontWeight = FontWeight.Bold
//                    ),
//                    color = Color.DarkGray,
//                    text = presentSessionCount
//                )
//            }
//        }
//    }
//}

@Composable
fun DividerLine() {
    Divider(
        color = colorResource(R.color.grey_700),
        thickness = 1.dp,
        modifier = Modifier.padding(5.dp)
    )
}

//@Composable
//fun FindMyChildComponent(
//    onNavigateToFindMyChildClicked: () -> Unit
//) {
//    Card(
//        modifier = Modifier.padding(5.dp),
//        shape = RoundedCornerShape(10.dp),
//        border = BorderStroke(1.dp, Color.LightGray),
//        colors = CardDefaults.cardColors(Color.White)
//    ) {
//        Row(
//            modifier = Modifier
//                .background(Color.White)
//                .fillMaxWidth()
//                .padding(10.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Card(
//                    shape = RoundedCornerShape(5.dp),
//                    modifier = Modifier.padding(start = 5.dp, top = 10.dp, bottom = 10.dp),
//                    border = BorderStroke(2.dp, colorResource(id = R.color.light_blue)),
//                    colors = CardDefaults.cardColors(Color.White)
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_location_map),
//                        contentDescription = null
//                    )
//                }
//                Column(
//                    modifier = Modifier.padding(start = 10.dp),
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Text(
//                        style = TextStyle(
//                            fontSize = 16.sp,
//                            fontWeight = FontWeight.Bold
//                        ),
//                        color = Color.DarkGray,
//                        text = "Find My Child"
//                    )
//                    Text(
//                        style = TextStyle(
//                            fontSize = 13.sp
//                        ),
//                        color = Color.DarkGray,
//                        text = stringResource(id = R.string.tap_navigation)
//                    )
//                }
//            }
//            Icon(
//                modifier = Modifier
//                    .size(30.dp)
//                    .clickable {
//                        onNavigateToFindMyChildClicked()
//                    },
//                painter = painterResource(id = R.drawable.ic_next_arrow),
//                tint = colorResource(id = R.color.grey_700),
//                contentDescription = "Navigate to Child's Location"
//            )
//        }
//    }
//}

//@Composable
//fun QuickJumpComponent(
//    onNavigateToCoursesClicked: () -> Unit,
//    onNavigateToRecentDocumentsClicked: () -> Unit,
//    onNavigateToRecentActivitiesClicked: () -> Unit,
//    onNavigateToAttendanceReportClicked: () -> Unit,
//    onNavigateToCalendarClicked: () -> Unit,
//
//    ) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(10.dp)
//    ) {
//        Text(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 10.dp, top = 10.dp, bottom = 5.dp, end = 10.dp),
//            style = TextStyle(
//                fontSize = 14.sp,
//                fontWeight = FontWeight.Medium
//            ),
//            color = colorResource(id = R.color.grey_700),
//            text = "Quick Jump to"
//        )
//        QuickJumpComponentItem(
//            icon = painterResource(id = R.drawable.ic_courses),
//            text = "Courses",
//            onIconClicked = onNavigateToCoursesClicked
//
//        )
//        QuickJumpComponentItem(
//            icon = painterResource(id = R.drawable.ic_recent_documents),
//            text = "Recent Documents",
//            onIconClicked = onNavigateToRecentDocumentsClicked
//        )
//        QuickJumpComponentItem(
//            icon = painterResource(id = R.drawable.ic_recent_activity),
//            text = "Recent Activities",
//            onIconClicked = onNavigateToRecentActivitiesClicked
//        )
//        QuickJumpComponentItem(
//            icon = painterResource(id = R.drawable.ic_attendance_report),
//            text = "Attendance Report",
//            onIconClicked = onNavigateToAttendanceReportClicked
//        )
//        QuickJumpComponentItem(
//            icon = painterResource(id = R.drawable.ic_calendar),
//            text = "Calendar",
//            onIconClicked = onNavigateToCalendarClicked
//        )
//    }
//}

//@Composable
//fun QuickJumpComponentItem(
//    icon: Painter,
//    text: String,
//    onIconClicked: () -> Unit
//) {
//    Card(
//        shape = RoundedCornerShape(5.dp),
//        modifier = Modifier
//            .padding(5.dp)
//            .fillMaxWidth(),
//        border = BorderStroke(1.dp, Color.Gray),
//        colors = CardDefaults.cardColors(Color.White)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(10.dp),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Icon(
//                    painter = icon,
//                    tint = colorResource(id = R.color.grey_700),
//                    contentDescription = null
//                )
//                Spacer(modifier = Modifier.padding(start = 10.dp))
//                Text(
//                    style = TextStyle(
//                        fontSize = 15.sp,
//                        fontWeight = FontWeight.Medium
//                    ),
//                    color = colorResource(id = R.color.grey_700),
//                    text = text
//                )
//            }
//            Icon(
//                modifier = Modifier.clickable {
//                    onIconClicked()
//                },
//                tint = colorResource(id = R.color.grey_700),
//                painter = painterResource(id = R.drawable.ic_next_arrow),
//                contentDescription = "Navigate Icon"
//            )
//        }
//    }
//}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NeedHelpPreview() {
    Column {
       // EmergencyAlertRequestScreen()
    }
}


@Composable
fun SOSEmergencyAlert(
    studentName: String,
    isNeedHelpPrompt: Boolean,
    timer: String?,
    onCallNowClicked: () -> Unit,
    onViewLocationClicked: () -> Unit,
) {
    Card(
        border = BorderStroke(1.dp, Color.Red),
        colors = CardDefaults.cardColors(
            if (isNeedHelpPrompt) Color.Red
            else colorResource(id = R.color.light_red)
        ),
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_alert),
                tint = if (isNeedHelpPrompt) Color.White
                else Color.Red,
                contentDescription = "Alert Icon"
            )
            Spacer(modifier = Modifier.padding(7.dp))
            Text(
                color = if (isNeedHelpPrompt) Color.White
                else Color.Red,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                ),
                text = if (isNeedHelpPrompt) stringResource(R.string.need_help)
                else stringResource(R.string.emergency_alert_cancelled)
            )
            if (isNeedHelpPrompt) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_alert_timer),
                        tint = Color.White,
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier.padding(start = 3.dp),
                        style = TextStyle(
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp
                        ),
                        text = timer ?: ""
                    )
                }
            }
        }
        Text(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp),
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            ),
            color = if (isNeedHelpPrompt) Color.White
            else Color.Red,
            text = if (isNeedHelpPrompt) stringResource(
                id = R.string.need_help_message,
                studentName
            )
            else stringResource(id = R.string.emergency_alert_message, studentName)
        )
        Divider(
            modifier = Modifier.padding(
                start = 20.dp,
                top = 10.dp,
                bottom = 10.dp,
                end = 20.dp
            ),
            thickness = 1.dp,
            color = colorResource(id = R.color.divider_red)
        )
        Row(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, bottom = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f),
                onClick = {
                    onCallNowClicked()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_call_now_filled),
                    tint = if (isNeedHelpPrompt) Color.Red
                    else colorResource(id = R.color.digi_blue),
                    contentDescription = "Call Now"
                )
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (isNeedHelpPrompt) Color.Red
                        else colorResource(id = R.color.digi_blue)
                    ),
                    text = stringResource(id = R.string.call_now)
                )
            }
            Spacer(modifier = Modifier.padding(start = 10.dp))
            Button(
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f),
                onClick = {
                    onViewLocationClicked()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_view_location),
                    tint = if (isNeedHelpPrompt) Color.Red
                    else colorResource(id = R.color.digi_blue),
                    contentDescription = "View Location"
                )
                Text(
                    modifier = Modifier.padding(start = 5.dp),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (isNeedHelpPrompt) Color.Red
                        else colorResource(id = R.color.digi_blue)
                    ),
                    text = stringResource(id = R.string.view_location)
                )
            }
        }
    }
}


//@Composable
//fun SOSTimer(
//    totalTime: Long = 10L * 1000L,
//    currentTime: Long,
//    value: Float,
//    startTimer: () -> Unit
//) {
//    val initialValue = 1f
//    var size by remember { mutableStateOf(IntSize.Zero) }
//
//
//    LaunchedEffect(key1 = Unit) {
//        startTimer()
//    }
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(200.dp)
//            .padding(10.dp)
//            .fillMaxSize()
//            .onSizeChanged { size = it }
//    ) {
//        Canvas(modifier = Modifier.size(200.dp)) {
//            drawArc(
//                color = Color.LightGray,
//                startAngle = 0f,
//                sweepAngle = 360f,
//                useCenter = false,
//                size = Size(size.width.toFloat(), size.height.toFloat()),
//                style = Stroke(40F)
//            )
//            drawArc(
//                color = Color.Red,
//                startAngle = -90f,
//                sweepAngle = 360f * value,
//                useCenter = false,
//                size = Size(size.width.toFloat(), size.height.toFloat()),
//                style = Stroke(40F)
//            )
//        }
//        Text(
//            modifier = Modifier.padding(5.dp),
//            text = String.format("%02d", currentTime / 1000L),
//            fontSize = 80.sp,
//            color = Color.LightGray,
//            textAlign = TextAlign.Center
//        )
//    }
//}

//@Composable
//fun EmergencyAlertRequestScreen(
//    currentTime: Long,
//    value: Float,
//    startTimer: () -> Unit
//) {
//    Column(
//        modifier = Modifier
//            .background(Color.White)
//            .fillMaxSize()
//            .padding(10.dp),
//        verticalArrangement = Arrangement.SpaceBetween,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            style = TextStyle(
//                fontWeight = FontWeight.Bold,
//                color = Color.LightGray,
//                fontSize = 24.sp
//            ),
//            text = "Emergency Alert Request will be Sent in"
//        )
//        SOSTimer(
//            currentTime = currentTime,
//            value = value,
//            startTimer = startTimer
//        )
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 10.dp, end = 10.dp),
//            horizontalAlignment = Alignment.Start
//        ) {
//            Text(
//                modifier = Modifier.padding(start = 10.dp),
//                style = TextStyle(
//                    fontWeight = FontWeight.Bold,
//                    color = Color.LightGray,
//                    fontSize = 20.sp
//                ),
//                text = "Please Stay Calm!"
//            )
//            Text(
//                modifier = Modifier.padding(top = 3.dp, start = 10.dp),
//                style = TextStyle(
//                    color = Color.LightGray,
//                    fontSize = 16.sp
//                ),
//                text = "We will notify an emergency alert to all your contact list. They will reach you soon!"
//            )
//            Spacer(modifier = Modifier.padding(10.dp))
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 10.dp)
//            ) {
//                OutlinedButton(
//                    border = BorderStroke(1.dp, Color.LightGray),
//                    colors = ButtonDefaults.buttonColors(Color.White),
//                    shape = RoundedCornerShape(5.dp),
//                    modifier = Modifier
//                        .padding(5.dp)
//                        .weight(1f),
//                    onClick = {}
//                ) {
//                    Text(
//                        color = Color.LightGray,
//                        text = "Cancel, I am Safe",
//                        fontSize = 14.sp,
//                    )
//                }
//                OutlinedButton(
//                    border = BorderStroke(1.dp, Color.Red),
//                    colors = ButtonDefaults.buttonColors(Color.Red),
//                    shape = RoundedCornerShape(5.dp),
//                    modifier = Modifier
//                        .padding(5.dp)
//                        .weight(1f),
//                    onClick = {}
//                ) {
//                    Text(
//                        color = Color.White,
//                        text = "Send Now",
//                        fontSize = 14.sp,
//                    )
//                }
//            }
//        }
//    }
//}