package vendingmachine.domain

class ChangeMachine {
    var coins = listOf<Int>()


    fun returnMoney(money: Int): List<Int> {
        var result = mutableListOf(0, 0, 0, 0)
        val coin = listOf(500,100,50,10)
        var money = money
        coins.forEachIndexed { index, i ->
            if(coin[index] <= money){
                money/coin[index]
            }
        }

        return result
    }

    private fun checkCoins(money: Int) = !isEmpty() && !isEqual(money)

    private fun isEmpty() = coins.all { it == 0 }
    private fun isEqual(money: Int) = money == 0

}