// MainActivity_Ruta3.kt
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdaptiveLayoutApp()
        }
    }
}

@Composable
fun AdaptiveLayoutApp() {
    // Obtenemos la configuración actual del dispositivo
    val configuration = LocalConfiguration.current
    // Consideramos "pantalla ancha" si supera los 600 dp de ancho
    val isExpandedScreen = configuration.screenWidthDp > 600

    if (isExpandedScreen) {
        // Diseño para pantallas grandes
        ExpandedScreenLayout()
    } else {
        // Diseño para celulares estándar
        CompactScreenLayout()
    }
}

@Composable
fun CompactScreenLayout() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Modo Compacto (Celular Vertical)", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Card(modifier = Modifier.fillMaxWidth().height(150.dp)) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Bandeja de Entrada")
            }
        }
    }
}

@Composable
fun ExpandedScreenLayout() {
    Row(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Panel izquierdo (Lista)
        Card(modifier = Modifier.weight(1f).fillMaxHeight()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Menú Lateral")
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        // Panel derecho (Detalles)
        Card(
            modifier = Modifier.weight(2f).fillMaxHeight(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Modo Expandido (Tablet/Horizontal) - Leyendo Mensaje", style = MaterialTheme.typography.headlineSmall)
            }
        }
    }
}
