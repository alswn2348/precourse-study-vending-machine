package vendingmachine.domain

const val NAME = 0
const val PRIZE = 1
const val COUNT = 2

class Shelf {

    var products = mutableMapOf<String, MutableList<Int>>()
    fun add(product: String) {
        val a = product.split(";")
                .map {
                    it.replace(Regex("\\[|\\]"), "")
                            .split(",")
                }
        a.forEach{
            products[it[NAME]] = mutableListOf(it[PRIZE].toInt(),it[COUNT].toInt())
        }
    }

    fun takeOut(name: String) {
        products[name]!![1] -= 1
    }

    fun isEmpty() = products.all { it.value[1] == 0 }
    fun isExpensive(money: Int) = products.all { it.value[0] > money}

}




