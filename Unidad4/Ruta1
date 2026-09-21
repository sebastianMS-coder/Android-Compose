// MainActivity_Ruta1.kt
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

// 1. Estado de la Interfaz (UI State)
data class InventoryUiState(
    val totalItems: Int = 0,
    val outOfStock: Boolean = true
)

// 2. ViewModel (Lógica de negocio separada de la UI)
class InventoryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(InventoryUiState())
    val uiState: StateFlow<InventoryUiState> = _uiState.asStateFlow()

    fun addItem() {
        _uiState.update { currentState ->
            currentState.copy(
                totalItems = currentState.totalItems + 1,
                outOfStock = false
            )
        }
    }
}

// 3. Interfaz Gráfica que observa el Estado
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InventoryApp()
        }
    }
}

@Composable
fun InventoryApp(viewModel: InventoryViewModel = viewModel()) {
    // Recolectamos el estado de forma reactiva
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Gestor de Inventario FISI", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Artículos en stock: ${uiState.totalItems}", style = MaterialTheme.typography.titleLarge)
        
        if (uiState.outOfStock) {
            Text(text = "¡Atención! Sin inventario", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { viewModel.addItem() }) {
            Text("Ingresar Artículo")
        }
    }
}
