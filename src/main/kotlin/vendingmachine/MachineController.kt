package vendingmachine

import vendingmachine.domain.Shelf
import vendingmachine.view.View

class MachineController {
    private val shelf = Shelf()
    private var coin = 0
    private val view = View()
    fun run() {
        coin = view.coin()
        buy()
    }

    private fun buy() {
        val name = view.name()
        shelf.takeOut(name)
        coin -= shelf.products[name]!![0]
    }
}