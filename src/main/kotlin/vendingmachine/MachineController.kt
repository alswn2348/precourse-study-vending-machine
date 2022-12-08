package vendingmachine

import vendingmachine.domain.RandomCoinGenerator
import vendingmachine.domain.Shelf
import vendingmachine.view.View

class MachineController {
    private val shelf = Shelf()
    private val view = View()
    private val change = mutableListOf<Int>() // 500 , 100 , 50 , 10
    private var money = view.money()
    private val randomCoinGenerator = RandomCoinGenerator()
    fun run() {
        generateCoin()
        view.generatedCoin()
        while (checkCanBuyMore()) {
            buy()
        }
        changeCalculator()
        view.change()
    }

    private fun generateCoin() {
        var coin = view.coin()
        while (coin != 0) {
            val a = randomCoinGenerator.generate(coin)
            when (a) {
                500 -> change[0]++
                100 -> change[1]++
                50 -> change[2]++
                10 -> change[3]++
            }
            coin -= a
        }
    }

    private fun changeCalculator() {

    }

    private fun buy() {
        val name = view.name()
        shelf.takeOut(name)
        money -= shelf.products[name]!![0]
    }

    private fun checkCanBuyMore(): Boolean {
        return shelf.isEmpty() || shelf.isExpensive(money)
    }
}