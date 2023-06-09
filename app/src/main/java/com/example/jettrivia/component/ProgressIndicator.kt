package com.example.jettrivia.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.internal.enableLiveLiterals
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Preview
@Composable
fun ProgressIndicator(currentQuestionNumber: MutableState<Int>,totalQuestions:Int) {

    val progressAmount = remember(currentQuestionNumber.value){
        mutableStateOf( currentQuestionNumber.value.toFloat()/totalQuestions)
    }
    val gradient = Brush.linearGradient(listOf(Color.Blue,Color.Magenta))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(Color.Transparent)
            .border(1.dp,MaterialTheme.colorScheme.onBackground, RoundedCornerShape(22.dp))

    ) {
        Button(
            onClick = {},
            colors= buttonColors(
                Color.Transparent,
                Color.Transparent,
                Color.Transparent,
                Color.Transparent
            ),
            enabled =false,
            modifier = Modifier
                .background(gradient)
                .fillMaxWidth(progressAmount.value)
                .fillMaxHeight()

        ) {

        }
    }

}