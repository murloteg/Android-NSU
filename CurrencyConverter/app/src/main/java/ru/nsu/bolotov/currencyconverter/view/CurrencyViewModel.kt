package ru.nsu.bolotov.currencyconverter.view

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.nsu.bolotov.currencyconverter.api.RetrofitInstance
import ru.nsu.bolotov.currencyconverter.model.Currency
import ru.nsu.bolotov.currencyconverter.model.NameAndCurrency

class CurrencyViewModel : ViewModel() {
    private val _currencies = MutableStateFlow<List<Currency>>(emptyList())
    val currencies: StateFlow<List<Currency>> = _currencies

    fun fetchCurrencies() {
        try {
            RetrofitInstance.api.getCurrencies().enqueue(object : Callback<NameAndCurrency> {
                override fun onResponse(
                    call: Call<NameAndCurrency>,
                    response: Response<NameAndCurrency>
                ) {
                    if (response.isSuccessful) {
                        val currencyList = response.body()?.Valute?.values?.toList() ?: emptyList()
                        _currencies.value = currencyList
                        Log.i("Currencies REQUEST", "Currencies: $currencyList")
                    }
                }

                override fun onFailure(call: Call<NameAndCurrency>, t: Throwable) {
                    Log.e("CurrencyViewModel ERROR", "Request failed", t)
                }
            })
        } catch (e: Exception) {
            Log.e("CurrencyViewModel ERROR", "Error while fetching currencies", e)
        }
    }

    fun convertCurrency(amountInRub: Double, currencyName: String): String {
        val selectedCurrency = currencies.value.find { it.Name == currencyName }
        return if (selectedCurrency != null) {
            val result = amountInRub / selectedCurrency.Value
            Log.i("Conversion OUTPUT", "Conversion result: $result")
            String.format("%.5f", result)
        } else {
            Log.e("Conversion ERROR", "Conversion failed!")
            "???"
        }
    }
}
