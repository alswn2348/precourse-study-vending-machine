package vendingmachine.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ShelfTest {
    @Test
    fun `input_콜라,1000,10_콜라,1000,10`() {
        val shelf = Shelf()
        shelf.add("[콜라,1000,10]")
        assertThat(shelf.products["콜라"]!![1]).isEqualTo(10)
    }

    @Test
    fun `buy_콜라,1000,10_콜라,1000,10`() {
        val shelf = Shelf()
        shelf.add("[콜라,1000,10]")
        shelf.takeOut("콜라")
        assertThat(shelf.products["콜라"]!![1]).isEqualTo(9)
    }
}