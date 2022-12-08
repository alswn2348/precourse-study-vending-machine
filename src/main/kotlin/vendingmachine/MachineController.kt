package vendingmachine

import vendingmachine.domain.ChangeMachine
import vendingmachine.domain.RandomCoinGenerator
import vendingmachine.domain.Shelf
import vendingmachine.view.View

class MachineController {
    private val shelf = Shelf()
    private val view = View()
    private val changeMachine = ChangeMachine()
    private var money =0
    private val randomCoinGenerator = RandomCoinGenerator()
    fun run() {
        init()
        while (checkCanBuyMore()) {
            buy()
        }

        view.change(changeMachine.returnMoney())
    }

    private fun init() {
        changeMachine.setChange(generateChange())
        view.generatedCoin()
        money = view.money()
        shelf.add(view.products())
    }

    private fun generateChange(): List<Int> {
        val change = mutableListOf(0,0,0,0) // 500 , 100 , 50 , 10
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

    private fun checkCanBuyMore(): Boolean {
        return shelf.isEmpty() || !shelf.isExpensive(money)
    }
}