package ru.nsu.bolotov.currencyconverter.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://www.cbr-xml-daily.ru/"

    val api: CbrController by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CbrController::class.java)
    }
}
