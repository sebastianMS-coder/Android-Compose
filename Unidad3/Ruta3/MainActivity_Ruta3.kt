// MainActivity_Ruta3.kt
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
// import com.example.tu_proyecto.R 

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HeroesApp()
        }
    }
}

data class Hero(val name: String, val description: String, val imageResId: Int)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesApp() {
    val heroes = listOf(
        Hero("Kotlin Man", "Controla el código nulo", R.drawable.hero_image),
        Hero("Compose Girl", "Dibuja interfaces a la velocidad de la luz", R.drawable.hero_image),
        Hero("Ingeniero FISI", "Despliega servidores en segundos", R.drawable.hero_image)
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Superhéroes App", style = MaterialTheme.typography.displayLarge) }
            )
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(heroes) { hero ->
                HeroItem(hero = hero, modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = hero.name, style = MaterialTheme.typography.titleLarge)
                Text(text = hero.description, style = MaterialTheme.typography.bodyMedium)
            }
            Image(
                painter = painterResource(hero.imageResId),
                contentDescription = null,
                modifier = Modifier.size(72.dp).clip(MaterialTheme.shapes.small)
            )
        }
    }
}
