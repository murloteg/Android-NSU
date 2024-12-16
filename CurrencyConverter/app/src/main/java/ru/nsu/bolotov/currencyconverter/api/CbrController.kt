package ru.nsu.bolotov.currencyconverter.api

import retrofit2.Call
import retrofit2.http.GET
import ru.nsu.bolotov.currencyconverter.model.NameAndCurrency

interface CbrController {
    @GET("daily_json.js")
    fun getCurrencies(): Call<NameAndCurrency>
}
