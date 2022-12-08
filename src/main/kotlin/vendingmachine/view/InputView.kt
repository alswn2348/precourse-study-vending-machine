package vendingmachine.view

import camp.nextstep.edu.missionutils.Console
import vendingmachine.exceptions.ExceptionHandler
import vendingmachine.exceptions.ExceptionHandler.toIntOrThrow


class InputView {
    fun readCoin(): Int {
        val change = Console.readLine().toIntOrThrow()
        ExceptionHandler.checkChange(change)
        return change
    }

    fun readProducts(): String {
        val products = Console.readLine()
        ExceptionHandler.checkProducts(products)
        return products
    }

    fun readMoney(): Int {
        val coin = Console.readLine().toIntOrThrow()
        ExceptionHandler.checkCoin(coin)
        return coin
    }

    fun readName(): String {
        val name = Console.readLine()
        ExceptionHandler.checkProducts(name)
        return name
    }


}