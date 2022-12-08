package vendingmachine.exceptions

object ExceptionHandler {
    fun checkChange(change: Int) {

    }

    fun checkProducts(products: String) {

    }

    fun checkCoin(coin: Int) {

    }

    fun checkCarName(carNames: List<String>) {
        carNames.forEach {
            require(it.length <= 10) { "자동차 이름은 5글자 이하 여야 합니다." }
        }
    }

    fun String.toIntOrThrow(): Int = requireNotNull(toIntOrNull()) { "숫자여야 합니다." }

}