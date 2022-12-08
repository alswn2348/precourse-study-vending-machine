package vendingmachine.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ShelfTest {
   @Test
    fun `input_콜라,1000,10_콜라,1000,10`() {
        val shelf = Shelf()
        shelf.add("[콜라,1000,10]")
        assertThat(shelf.products).contains(mapOf("콜라" to listOf(1000,10)))
    }
    /*
        @Test
        fun `buy_콜라,1000,10_콜라,1000,10`() {
            val shelf = Shelf()
            shelf.add("[콜라,1000,10]")
            shelf.buy("콜라")
            assertThat(shelf.products).contains(listOf("콜라", "1000", "9"))
        }*/
}