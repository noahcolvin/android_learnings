package aquarium5

import java.util.*

data class Fish(var name: String)

fun main() {
    fishExamples()
}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

fun fishExamples() {
    val fish = Fish("splashy")

    myWith(fish.name) {
        println(replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() })
    }

    println(fish.run { name })

    println(fish.apply { })

    val fish2 = Fish("splashy").apply { name = "Bob" }

    println(fish2.name)

    println(fish.let { it.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } }
        .let { it + "fish" }
        .let { it.length }
        .let { it + 31 })

    val myFish = listOf(Fish("flipper"))
}