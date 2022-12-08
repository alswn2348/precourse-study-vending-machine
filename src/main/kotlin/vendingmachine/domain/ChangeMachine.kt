package vendingmachine.domain

class ChangeMachine {
    var money = 0
    private var change = listOf<Int>()
    fun setChange(change: List<Int>) {
        this.change = change
    }

    fun returnMoney(): String {
        return ""
    }


}