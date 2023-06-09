package com.example.jettrivia.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettrivia.model.Questions
import com.example.jettrivia.model.QuestionsItem

@Preview
@Composable
fun QuestionTracker(counter: Int = 10, total: Int? = 3000) {
    Text(
        text = buildAnnotatedString {
            withStyle(SpanStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)) {
                append("Question $counter/")
            }
            withStyle(SpanStyle(fontSize = 16.sp, fontWeight = FontWeight.Light)) {
                if (total != null) {
                    append("${total+1}")
                }
            }
        },
        modifier = Modifier
            .padding(10.dp)
    )
}

@Composable
fun DottedLine(pathEffect: PathEffect) {
    val color = MaterialTheme.colorScheme.onSurface
    Canvas(
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
    ) {

        drawLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(size.width, 0f),
            pathEffect = pathEffect
        )
    }
}
