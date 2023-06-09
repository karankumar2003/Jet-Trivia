package com.example.jettrivia.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.model.QuestionsItem
import com.example.jettrivia.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val data: MutableState<DataOrException<ArrayList<QuestionsItem>,Boolean,Exception>>
    = mutableStateOf(DataOrException(null,true,Exception()))

    init {
        viewModelScope.launch {
            data.value = repository.getAllQuestions()

        }
    }

}