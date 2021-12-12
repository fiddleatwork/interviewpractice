package coding.crackingthecodinginterview

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class P71 {

    val magazine =
        "The quick pay fox jumped one happy million, but not all of us will eat cream cheese or oatmeal when we be happy as you."

    @Test
    fun `can make ransom`() {
        assertThat(
            ransomPossible(
                "Pay us one million or you will not be happy.",
                magazine
            )
        ).isTrue
    }

    @Test
    fun `can not make ransom due to missing word`() {
        assertThat(
            ransomPossible(
                "Pay us one million or you will not be in a good mood.",
                magazine
            )
        ).isFalse
    }

    private fun String.words() =
        lowercase(Locale.getDefault())
            .split(" ", ".", ",")
            .filter { it.isNotBlank() && it.isNotEmpty() }

    private fun ransomPossible(ransom: String, magazine: String): Boolean =
        magazine.words()
            .also {
                println("Magazine words $it")
            }
            .let { magazineWords ->
                ransom.words()
                    .associateWith { it in magazineWords }
                    .also {
                        println(it)
                    }
                    .filterNot { it.value }
                    .isEmpty()
            }

}