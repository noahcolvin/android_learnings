package lesson4.Spices

fun main() {
    val curry = Curry("mild")
    curry.prepareSpice()
    println("Color: ${curry.color}")
}

interface Grinder {
    fun grind()
}

sealed class Spice(val name: String, var spiciness: String = "mild", color: SpiceColor) : SpiceColor by color {
    val heat: Int
        get() = when (spiciness) {
            "mild" -> 5
            else -> 0
        }

    abstract fun prepareSpice()
}

class Curry(spiciness: String) : Spice("curry", spiciness, YellowSpiceColor), Grinder {
    override fun grind() {
        println("Grinding $name")
    }

    override fun prepareSpice() {
        grind()
    }
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00)
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}