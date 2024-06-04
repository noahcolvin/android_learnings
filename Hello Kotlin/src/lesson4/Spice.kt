package lesson4

class Spice(val name: String, var spiciness: String = "mild") {
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            else -> 0
        }
}

fun main(args: Array<String>) {
    val spices = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "spicy"),
        Spice("ginger", "mild"),
        Spice("red curry", "medium"),
        Spice("green curry", "mild"),
        Spice("hot pepper", "extremely spicy")
    )

    val lessSpicy = spices.filter { it.heat < 5 }
    for (element in lessSpicy) println(element.name)
}

fun makeSalt() = Spice("Salt")