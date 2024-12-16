package ru.nsu.bolotov.currencyconverter.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.bolotov.currencyconverter.R
import ru.nsu.bolotov.currencyconverter.model.Currency

@Composable
fun ConversionResultTable(conversionResult: String, selectedCurrency: Currency?) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp)
            .border(BorderStroke(2.dp, Color.Black), shape = RoundedCornerShape(4.dp))
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .weight(2f)
                .height(75.dp)
                .border(BorderStroke(1.dp, Color.Black))
                .background(Color.Transparent)
                .padding(8.dp)
        ) {
            Text(
                text = selectedCurrency?.Name ?: "Не выбрана",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .height(75.dp)
                .border(BorderStroke(1.dp, Color.Black))
                .background(color = colorResource(id = R.color.peach))
                .padding(8.dp)
        ) {
            Text(
                text = conversionResult,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}
