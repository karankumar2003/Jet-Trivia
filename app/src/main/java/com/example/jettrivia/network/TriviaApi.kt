package com.example.jettrivia.network

import com.example.jettrivia.model.Questions
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface TriviaApi {

    @GET("world.json")
    suspend fun getAllQuestions(): Questions
}