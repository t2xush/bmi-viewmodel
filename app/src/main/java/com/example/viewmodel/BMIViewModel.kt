// BmiViewModel.kt
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {

    var heightInput: String by mutableStateOf("")
    var weightInput: String by mutableStateOf("")
    private var _bmi: Float by mutableStateOf(0.0f)

    val bmi: Float
        get() = _bmi

    fun updateHeight(height: String) {
        heightInput = height.replace(',', '.')
        calculateBmi()
    }

    fun updateWeight(weight: String) {
        weightInput = weight.replace(',', '.')
        calculateBmi()
    }

    private fun calculateBmi() {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toFloatOrNull() ?: 0.0f

        _bmi = if (weight > 0 && height > 0) weight / (height * height) else 0.0f
    }
}
