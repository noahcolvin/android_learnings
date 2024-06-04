import java.util.*

fun main() {
    whatShouldIDoToday("sad")

    val rollDice = { sides: Int -> Random().nextInt(sides + 1) }
    println(rollDice(6))
    val rollDice2: (Int) -> Int = { sides -> Random().nextInt(sides + 1) }
    println(rollDice2(12))

    gamePlay(rollDice2)
}

fun gamePlay(diceRoll: (Int) -> Int) {
    println(diceRoll(12))
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temp: Int = 24) {
    val toDo = when {
        isHappyAndSunny(mood, weather) -> "go for a walk"
        isColdSadAndRainy(mood, weather, temp) -> "stay in bed"
        isHot(temp) -> "go swimming"
        else -> "Stay home and read."
    }
    println(toDo)
}

private fun isHot(temp: Int) = temp > 35

private fun isColdSadAndRainy(mood: String, weather: String, temp: Int) =
    mood == "sad" && weather == "rainy" && temp == 0

private fun isHappyAndSunny(mood: String, weather: String) = mood == "happy" && weather == "sunny"