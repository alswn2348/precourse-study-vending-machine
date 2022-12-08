package vendingmachine.domain

const val NAME = 0
const val PRIZE = 1
const val COUNT = 2

class Shelf {

    var products = mutableMapOf<String, MutableList<Int>>()
    fun add(product: String) {
        val a = product.replace(Regex("\\[|\\]"), "")
                .split(",")
        products[a[NAME]] = mutableListOf(a[PRIZE].toInt(), a[COUNT].toInt())
    }

    fun takeOut(name: String) {
        products[name]!![1] -= 1
    }
}




