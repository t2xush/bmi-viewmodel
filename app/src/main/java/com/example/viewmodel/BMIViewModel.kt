// BmiViewModel.kt
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class BmiViewModel : ViewModel() {

    var heightInput: String by mutableStateOf("")
    var weightInput: String by mutableStateOf("")
    private var _bmi: MutableState<Float> = mutableStateOf(0.0f)

    val bmi: State<Float>
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

        _bmi.value = if (weight > 0 && height > 0) weight / (height * height) else 0.0f
    }
}
