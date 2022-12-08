package vendingmachine.view

const val ERROR = "[ERROR]"

class OutputView {
    fun printError(e: IllegalArgumentException) {
        println("$ERROR ${e.message}")
    }

    fun printCoin(coin: List<Int>) {
        println(buildString {
            appendLine("500원 - ${coin[0]}개")
            appendLine("100원 - ${coin[1]}개")
            appendLine("50원 - ${coin[2]}개")
            appendLine("10원 - ${coin[3]}개")
        }
        )
    }

    fun printChange(returnMoney: String) {

    }

    fun printBalance(money: Int) {
        println("투입 금액: ${money}원")
    }
}