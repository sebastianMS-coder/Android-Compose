// Ejercicios_Ruta1.kt
enum class Daypart { MORNING, AFTERNOON, EVENING }

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)

fun main() {
    val events = mutableListOf(
        Event(title = "Clase de Kotlin", description = "Aprender Compose", daypart = Daypart.MORNING, durationInMinutes = 120),
        Event(title = "Reunión de proyecto", daypart = Daypart.AFTERNOON, durationInMinutes = 45),
        Event(title = "Estudiar para examen", description = "Repasar apuntes", daypart = Daypart.EVENING, durationInMinutes = 90),
        Event(title = "Deporte", daypart = Daypart.MORNING, durationInMinutes = 60),
        Event(title = "Cena familiar", daypart = Daypart.EVENING, durationInMinutes = 120)
    )

    // 1. Filtrar eventos cortos (menos de 60 minutos)
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("Tienes ${shortEvents.size} evento(s) corto(s).")

    // 2. Agrupar por momento del día
    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} eventos")
    }

    // 3. Obtener solo los títulos usando map
    val eventTitles = events.map { it.title }
    println("Tus actividades de hoy: $eventTitles")
}
