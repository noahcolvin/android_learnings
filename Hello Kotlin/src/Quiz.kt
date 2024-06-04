fun main(){
    val fortune = getFortune()
    println("Your fortune is: $fortune")
}

fun getFortune() :String{
    val birthday = getBirthday()

    return when (birthday){
        28, 31 -> "You will have a great day!"
        in 1..7 -> "Things will go well for you today."
        else -> "Enjoy a wonderful day of success."
    }
}

fun getBirthday() :Int{
    print("Enter your birthday: ")
    val birthday = readlnOrNull()?.toIntOrNull() ?: 1
    return birthday
}