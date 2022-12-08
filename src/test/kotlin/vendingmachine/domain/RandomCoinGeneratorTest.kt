package vendingmachine.domain

import org.junit.jupiter.api.Test

class RandomCoinGeneratorTest {
    @Test
    fun `run_투입금액190_100이하의 동전`() {
        val randomCoin = RandomCoinGenerator()
        assert(randomCoin.generate(190) <= 100)
    }
}