package coding.crackingthecodinginterview

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.pow

class P79 {

    @Test
    fun `simple equals case`() {
        assertThat("10000".hexEquals("10")).isTrue
    }

    private fun String.hexEquals(s: String): Boolean {
        return fromBase(2) == s.fromBase(16) //s.convertHexToDecimal
    }

    @Test
    fun `convert binary to decimal`() {
        assertThat("011".fromBase(2)).isEqualTo(3)
        assertThat("000100000011".fromBase(2)).isEqualTo(259)
    }

    val lookup = listOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

    private fun String.fromBase(base: Int): Int {
        require(base in 2..16) { "Base must be between 2 & 16." }
        return reversed().mapIndexed { i, c ->
            val index = lookup.indexOf(c)
            index * base.toDouble().pow(i).toInt()
        }
            .sum()
    }

}

