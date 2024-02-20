package org.techtown.counterviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.techtown.counterviewmodel.ui.theme.CounterViewModelTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 이렇게 불러야 회전을 했을때도 데이터가 안사라지고 유지됨
            val viewModel : CounterViewModel by viewModels()

            CounterViewModelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TheCounterApp(viewModel)
                }
            }
        }
    }

    // 화면이 돌아가면 초기화됨 이것도 없애주기!
    // mvvn형ㅌ
    @Composable
    fun TheCounterApp(viewModel: CounterViewModel) {

        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Count: ${viewModel.count.value}",
                style = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold))

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Button(onClick = { viewModel.increment() }) {
                    Text(text = "Increment")
                }
                Button(onClick = { viewModel.decrement() }) {
                    Text(text = "Decrement")
                }
            }
        }

    }
}
