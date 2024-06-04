package lesson5.practice

fun main() {
    val allBooks = setOf("Macbeth", "Romeo and Juliet", "Hamlet", "A Midsummer Night's Dream")
    val library = mapOf("William Shakespeare" to allBooks)

    println(library.any { it.value.contains("Hamlet") })

    val moreBooks = mutableMapOf<String, String>("We Are Legion (We Are Bob)" to "Dennis E. Taylor")
    moreBooks.getOrPut("Project Hail Mary") { "Andy Weir" }
    println(moreBooks)
}