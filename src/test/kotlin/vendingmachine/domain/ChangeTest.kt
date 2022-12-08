package vendingmachine.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChangeTest {
     @Test
    fun `changeTest`() {
         val changeMachine = ChangeMachine()
         changeMachine.money = 500
         changeMachine.setChange(listOf(0, 4, 1, 1))
         val result = listOf("잔돈", "100원 - 4개", "50원 - 1개")
         assertThat(result).contains(changeMachine.returnMoney())
    }
}