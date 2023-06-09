package com.example.jettrivia.repository

import android.util.Log
import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.model.QuestionsItem
import com.example.jettrivia.network.TriviaApi
import javax.inject.Inject

class Repository @Inject constructor(private val api:TriviaApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionsItem>,Boolean,Exception>()

    suspend fun getAllQuestions():DataOrException<ArrayList<QuestionsItem>,Boolean,Exception>{
        try{
            dataOrException.isLoading = true
            dataOrException.data = api.getAllQuestions()
            if(dataOrException.data.toString().isNotEmpty()){
                dataOrException.isLoading = false
            }
        }catch (e:Exception){
            dataOrException.exception = e
            Log.d("repository", "getAllQuestions: ${dataOrException.exception!!.localizedMessage}")
        }
        return dataOrException
    }

}