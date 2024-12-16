package ru.nsu.bolotov.currencyconverter.ui.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import ru.nsu.bolotov.currencyconverter.model.Currency
import ru.nsu.bolotov.currencyconverter.ui.component.ConversionResultTable
import ru.nsu.bolotov.currencyconverter.ui.component.CurrencyConverterInput
import ru.nsu.bolotov.currencyconverter.ui.component.CurrencyListComponent
import ru.nsu.bolotov.currencyconverter.view.CurrencyViewModel

@Composable
fun CurrencyConverterScreen(viewModel: CurrencyViewModel) {
    val currencies = viewModel.currencies.collectAsState(initial = emptyList()).value
    val context = LocalContext.current

    val rubAmount = remember { mutableStateOf("") }
    val selectedCurrency = remember { mutableStateOf<Currency?>(null) }
    val conversionResult = remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Currency Converter")

        CurrencyConverterInput(
            rubAmount = rubAmount.value,
            onAmountChange = { rubAmount.value = it },
            onConvertClick = {
                Log.i("CurrencyConverterInput", "Clicked on converter button with amount: ${rubAmount.value}")
                val rubAmountValue = rubAmount.value.toDoubleOrNull()
                if (rubAmountValue != null && selectedCurrency.value != null) {
                    val result = viewModel.convertCurrency(rubAmountValue, selectedCurrency.value!!.Name)
                    conversionResult.value = result
                } else {
                    Log.e("CurrencyConverterInput ERROR", "Value or currency is incorrect")
                    Toast.makeText(context, "Введите сумму в рублях и выберите валюту для конвертации", Toast.LENGTH_SHORT).show()
                }
            }
        )

        ConversionResultTable(
            conversionResult = conversionResult.value,
            selectedCurrency = selectedCurrency.value
        )

        CurrencyListComponent(
            currencies = currencies,
            onCurrencySelected = { selectedCurrency.value = it; conversionResult.value = "???" }
        )
    }
}
