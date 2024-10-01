package ru.nsu.bolotov.navigation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.nsu.bolotov.navigation.ui.SimpleButton

@Composable
fun ThirdScreen(
    modifier: Modifier = Modifier,
    onNextButtonClicked: (Int) -> Unit,
) {
    Column {
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Third Screen", modifier.background(Color.Cyan).padding(40.dp))
        }
        Column(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            SimpleButton({ onNextButtonClicked(3) })
        }
    }
}
