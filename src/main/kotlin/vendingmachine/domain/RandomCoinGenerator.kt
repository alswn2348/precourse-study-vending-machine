package vendingmachine.domain

import camp.nextstep.edu.missionutils.Randoms
import vendingmachine.Coin

class RandomCoinGenerator {
    fun generate(inputMoney : Int): Int {
        val coin = listOf(500,100,50,10).filter { inputMoney > it }
        return Randoms.pickNumberInList(coin)
    }
}