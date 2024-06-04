package lesson6

fun List<Int>.divThree(): List<Int> = this.filter { it % 3 == 0 }

fun List<Int>.divisibleBy(block: (i: Int) -> Int): List<Int> {
    val x = mutableListOf<Int>()

    for (item in this) {
        if (block(item) == 0) {
            x.add(item)
        }
    }

    return x
}

fun main() {
    val numbers = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
    print(numbers.divisibleBy {
        it.rem(3)
    })

    println(numbers.divThree())
}