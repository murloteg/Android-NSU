package ru.nsu.bolotov.currencyconverter.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.nsu.bolotov.currencyconverter.R

@Composable
fun CurrencyConverterInput(
    rubAmount: String,
    onAmountChange: (String) -> Unit,
    onConvertClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            value = rubAmount,
            onValueChange = onAmountChange,
            label = {
                Text(
                    "Введите сумму (RUB)",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(8.dp))
                .border(BorderStroke(1.dp, Color.Black), RoundedCornerShape(8.dp))
                .padding(1.dp),
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            singleLine = true,
            textStyle = LocalTextStyle.current.copy(
                fontSize = 16.sp,
                color = Color.Black
            )
        )

        Button(
            onClick = onConvertClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.peach)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Перевести валюту",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}
