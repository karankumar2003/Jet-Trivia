package com.example.jettrivia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jettrivia.component.DottedLine
import com.example.jettrivia.component.ProgressIndicator
import com.example.jettrivia.component.QuestionAndChoices
import com.example.jettrivia.component.QuestionTracker
import com.example.jettrivia.model.Questions
import com.example.jettrivia.ui.theme.JetTriviaTheme
import com.example.jettrivia.viewModel.QuestionsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTriviaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: QuestionsViewModel = viewModel()) {

    val questions = viewModel.data.value.data?.toMutableList()
    val currentQuestionIndex = remember{
        mutableStateOf(0)
    }


    if(viewModel.data.value.isLoading == true){
        Box(modifier=Modifier.fillMaxSize()){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }else{
        Column(modifier=Modifier
            .fillMaxSize()
            .padding(10.dp)
        ){
            ProgressIndicator(currentQuestionIndex,questions!!.size)
            QuestionTracker(counter = currentQuestionIndex.value+1,total = questions?.size)
            DottedLine(pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f,10f),0f))
            QuestionAndChoices(currentQuestionIndex,questions!!)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetTriviaTheme {
        MainScreen()
    }
}