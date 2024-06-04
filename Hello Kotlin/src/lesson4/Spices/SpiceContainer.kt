package lesson4.Spices

fun main() {
    val c1 = SpiceContainer(Curry("mild"))
    val c2 = SpiceContainer(Curry("medium"))
    val c3 = SpiceContainer(Curry("spicy"))

    println(c1.label)
    println(c2.label)
    println(c3.label)
}

data class SpiceContainer(var spice: Spice) {
    val label = spice.name
}