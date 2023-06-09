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
                append("$total")
            }
        },
        modifier = Modifier
            .padding(20.dp)
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

@Composable
fun QuestionAndChoices(
    questionList: MutableList<QuestionsItem>
) {
    Column(modifier = Modifier.fillMaxSize()) {
        val chosenIndex = remember{
            mutableStateOf(-1)
        }
        val isChoiceCorrect = remember{
            mutableStateOf(false)
        }
        val currentQuestionNumber = remember{
            mutableStateOf(0)
        }

        Text(
            questionList[currentQuestionNumber.value].question,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
                .padding(10.dp)
        )
        questionList[currentQuestionNumber.value].choices.forEachIndexed { index,choice ->

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        1.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(10.dp)
                    .clickable {
                        chosenIndex.value = index
                        isChoiceCorrect.value =  questionList[currentQuestionNumber.value].choices[index]== questionList[currentQuestionNumber.value].answer
                    }
            ) {

                RadioButton(selected = chosenIndex.value == index ,
                    onClick = {
                        chosenIndex.value = index
                        isChoiceCorrect.value =  questionList[currentQuestionNumber.value].choices[index]== questionList[currentQuestionNumber.value].answer
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = if(isChoiceCorrect.value) Color.Green else Color.Red
                    ),
                    modifier=Modifier.padding(start=10.dp)
                )

                Text(choice, fontSize = 18.sp, modifier = Modifier.align(Alignment.CenterVertically))

            }
            Spacer(modifier = Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))


        Button(
            onClick = {
                currentQuestionNumber.value++
                chosenIndex.value=-1

            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Next", fontSize = 18.sp)
        }

    }
}