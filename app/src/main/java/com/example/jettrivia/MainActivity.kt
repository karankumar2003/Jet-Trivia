package com.example.jettrivia

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jettrivia.ui.theme.JetTriviaTheme
import com.example.jettrivia.viewModel.QuestionsViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

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
fun MainScreen(viewModel:QuestionsViewModel= androidx.lifecycle.viewmodel.compose.viewModel()) {
    val context = LocalContext.current
    val questions = viewModel.data.value.data?.toMutableList()
    if(viewModel.data.value.isLoading==true){

        Toast.makeText(context,"Loading",Toast.LENGTH_SHORT).show()
        Log.d("Haha", "Loading")
    }else{
        Log.d("Haha","Loading complete ")
        Toast.makeText(context,"Loading complete ${questions?.size}",Toast.LENGTH_SHORT).show()
        questions?.forEach {
            Log.d("Haha",it.question)
        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetTriviaTheme {

    }
}