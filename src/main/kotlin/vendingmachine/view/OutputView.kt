package vendingmachine.view

const val ERROR = "[ERROR]"

class OutputView {
    fun printError(e: IllegalArgumentException) {
        println("$ERROR ${e.message}")
    }

    fun printCoin() {

    }

    fun printChange() {

    }
}