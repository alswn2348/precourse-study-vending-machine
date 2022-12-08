package vendingmachine.view

const val ERROR = "[ERROR]"

class OutputView {
    fun printError(e: IllegalArgumentException) {
        println("$ERROR ${e.message}")
    }

    fun printCoin() {

    }

    fun printChange(returnMoney: String) {

    }

    fun printBalance(money: Int) {
        println("투입 금액: ${money}원")
    }
}