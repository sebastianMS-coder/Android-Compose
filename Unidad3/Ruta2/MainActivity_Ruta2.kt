// MainActivity_Ruta2.kt
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
// Asegúrate de importar tu R cuando estés en Android Studio
// import com.example.tu_proyecto.R 

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffirmationListApp()
        }
    }
}

data class Affirmation(val text: String, val imageResId: Int)

@Composable
fun AffirmationListApp() {
    // Lista de datos quemados para rapidez
    val affirmationList = listOf(
        Affirmation("Soy capaz de lograr mis metas", R.drawable.affirmation_image),
        Affirmation("Cada día aprendo algo nuevo en FISI", R.drawable.affirmation_image),
        Affirmation("El esfuerzo de hoy es el éxito de mañana", R.drawable.affirmation_image),
        Affirmation("Puedo superar cualquier error de código", R.drawable.affirmation_image),
        Affirmation("Mi potencial no tiene límites", R.drawable.affirmation_image)
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(affirmationList) { affirmation ->
            AffirmationCard(affirmation = affirmation, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResId),
                contentDescription = affirmation.text,
                modifier = Modifier.fillMaxWidth().height(150.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = affirmation.text,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
