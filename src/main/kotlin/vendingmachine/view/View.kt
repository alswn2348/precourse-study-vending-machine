package vendingmachine.view

const val COIN_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요."
const val MONEY_MESSAGE = "투입 금액을 입력해 주세요."
const val NAME_MESSAGE = "구매할 상품명을 입력해 주세요."
const val CHANGE_MESSAGE = "잔돈"
const val MESSAGE = "상품명과 가격, 수량을 입력해 주세요."


class View {
    private val outputView = OutputView()
    private val inputView = InputView()
    fun coin(): Int {
        println(COIN_MESSAGE)
        return repeatIfThrows(
                tryBlock = inputView::readCoin,
                catchBlock = outputView::printError,
        )
    }
    fun generatedCoin(){

    }

    fun money(): Int {
        println(MONEY_MESSAGE)
        return repeatIfThrows(
                tryBlock = inputView::readMoney,
                catchBlock = outputView::printError,
        )
    }

    fun products():String{
        println(MESSAGE)
        return repeatIfThrows(
                tryBlock = inputView::readProducts,
                catchBlock = outputView::printError,
        )
    }

    fun name(): String {
        println(NAME_MESSAGE)
        return repeatIfThrows(
                tryBlock = inputView::readName,
                catchBlock = outputView::printError,
        )
    }

    fun change(returnMoney: String) {
        println(CHANGE_MESSAGE)
        outputView.printChange(returnMoney)
    }

    private inline fun <reified T : Throwable, R> repeatIfThrows(
            tryBlock: () -> R,
            catchBlock: (T) -> Unit,
    ): R {
        while (true) {
            try {
                return tryBlock()
            } catch (t: Throwable) {
                if (t !is T) throw t
                catchBlock(t)
            }
        }
    }


}