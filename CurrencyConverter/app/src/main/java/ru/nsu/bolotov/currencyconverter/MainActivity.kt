package ru.nsu.bolotov.currencyconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import ru.nsu.bolotov.currencyconverter.ui.screen.CurrencyConverterScreen
import ru.nsu.bolotov.currencyconverter.ui.theme.CurrencyConverterTheme
import ru.nsu.bolotov.currencyconverter.view.CurrencyViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CurrencyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.fetchCurrencies()

        setContent {
            CurrencyConverterTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CurrencyConverterScreen(viewModel = viewModel)
                }
            }
        }
    }
}
