package vendingmachine

import vendingmachine.domain.ChangeMachine
import vendingmachine.domain.RandomCoinGenerator
import vendingmachine.domain.Shelf
import vendingmachine.view.View

class MachineController {
    private val shelf = Shelf()
    private val view = View()
    private val changeMachine = ChangeMachine()
    private var money = 0
    private val randomCoinGenerator = RandomCoinGenerator()
    fun run() {
        init()
        while (checkCanBuyMore()) {
            view.balance(money)
            buy()
        }
        view.balance(money)
        view.change(changeMachine.returnMoney(money))
    }

    private fun init() {
        changeMachine.coins = generateChange()
        view.generatedCoin(changeMachine.coins)
        shelf.add(view.products())
        money = view.money()
    }

    private fun generateChange(): List<Int> {
        val change = mutableListOf(0, 0, 0, 0) // 500 , 100 , 50 , 10
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
        return change
    }


    private fun buy() {
        val name = view.name()
        shelf.takeOut(name)
        money -= shelf.products[name]!![0]
    }

    private fun checkCanBuyMore() = !shelf.isEmpty() && !shelf.isExpensive(money)
}
