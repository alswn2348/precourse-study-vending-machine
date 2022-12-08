package vendingmachine.domain

class Shelf {

    var products = mutableListOf<Map<String, List<Int>>>()
    fun add(product: String) {
        val a = product.replace(Regex("\\[|\\]"), "")
                .split(",")
        products.add(mapOf(a[0] to listOf(a[1].toInt(), a[2].toInt())))
    }

    fun buy() {}
}




