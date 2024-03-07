package com.example.viewmodel// com.example.viewmodel.MainActivity.kt
import BmiViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viewmodel.ui.theme.ViewmodelTheme




class MainActivity : ComponentActivity() {
    private val viewModel: BmiViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewmodelTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Bmi(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun Bmi(viewModel: BmiViewModel) {
    Column(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // ... (unchanged part of your UI)

        OutlinedTextField(
            value = viewModel.heightInput,
            onValueChange = { viewModel.updateHeight(it) },
            label = { Text("height") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = viewModel.weightInput,
            onValueChange = { viewModel.updateWeight(it) },
            label = { Text("weight") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = stringResource(R.string.result, String.format("%.2f", viewModel.bmi.value).replace(',', '.')))
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ViewmodelTheme {

        Bmi(viewModel = BmiViewModel())
    }
}
