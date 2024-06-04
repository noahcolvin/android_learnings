package lesson4

fun main(args: Array<String>) {
    val simpleSpice = SimpleSpice()
    println("Name: ${simpleSpice.name}")
    println("Spiciness: ${simpleSpice.spiciness}")
    println("Heat: ${simpleSpice.heat}")
}

class SimpleSpice {
    val name: String = "curry"
    val spiciness: String = "mild"
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            else -> 0
        }
}