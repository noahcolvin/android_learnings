package lesson5

const val maxBooks = 5

fun main() {
    val book = Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, 100)
    println(book.getTitleAndAuthor())
    println(book.getTitleAuthorAndYear())
    println(book.canBorrow(6))
    book.printUrl()

    val puppy = Puppy()
    while (book.pages > 0) {
        puppy.playWithBook(book)
        println("${book.pages} left in ${book.title}")
    }
    println("Sad puppy, no more pages in ${book.title}")
}

class Book(val title: String, val author: String, var year: Int, var pages: Int = 0) {
    companion object {
        const val BASE_URL = "https://www.mybooks.net/"
    }

    fun getTitleAndAuthor(): Pair<String, String> {
        return title to author
    }

    fun getTitleAuthorAndYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }

    fun canBorrow(currentlyBorrowed: Int): Boolean {
        return currentlyBorrowed < maxBooks
    }

    fun printUrl() {
        println(BASE_URL + title.replace(" ", "_") + ".html")
    }
}

fun Book.weight() = pages * 1.5
fun Book.tornPages(torn: Int) {
    if (pages >= torn) pages -= torn
    else pages = 0
}

class Puppy {
    fun playWithBook(book: Book) {
        book.tornPages((0..10).random())
    }
}