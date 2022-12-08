package vendingmachine

import vendingmachine.domain.Shelf
import vendingmachine.view.View

class MachineController {
    private val shelf = Shelf()
    private var coin = 0
    private val view = View()
    private val change = view.change()
    fun run() {
        coin = view.coin()
        buy()
    }

    private fun buy() {
        val name = view.name()
        shelf.takeOut(name)
        coin -= shelf.products[name]!![0]
    }

    private fun checkCanBuyMore():Boolean{
      return  shelf.isEmpty()
    }
}