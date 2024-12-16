package ru.nsu.bolotov.currencyconverter.ui.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.platform.LocalContext
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.ui.res.colorResource
import ru.nsu.bolotov.currencyconverter.R
import ru.nsu.bolotov.currencyconverter.model.Currency

@Composable
fun CurrencyListComponent(
    currencies: List<Currency>,
    onCurrencySelected: (Currency) -> Unit
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        items(currencies) { currency ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .background(Color.White, RoundedCornerShape(4.dp))
                    .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(4.dp))
                    .clickable {
                        onCurrencySelected(currency)
                        Log.i("CurrencyListComponent", "Selected currency: ${currency.Name}")
                        Toast.makeText(context, "Выбрана валюта: ${currency.Name}", Toast.LENGTH_SHORT)
                            .show()
                    }
                    .padding(12.dp)
            ) {
                Text(
                    text = currency.Name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    color = colorResource(id = R.color.dark_text)
                )

                Text(
                    text = String.format("%.4f", currency.Value),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.light_text)
                )
            }
        }
    }
}
