package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.AssertionsForClassTypes
import org.junit.jupiter.api.Test
import kotlin.math.abs
import kotlin.math.sign

/**
 * Source: https://leetcode.com/problems/defuse-the-bomb/description/?envType=daily-question&envId=2024-11-18
 */
class Leet1652DefuseTheBombTest {

    // 1,2,3,4
    // get(4) => get(0)
    // get(7) => get(3)
    // get(9) => get(1)
    // get(-1) => get(3)
    // get(-2) => get(2)
    // get(-3) => get(1)
    // get(-4) ==> get(0)
    private fun IntArray.safeGet(i: Int) =
        if (i >= 0) {
            get(i % size)
        } else {
            get((size - abs(i)) % size)
        }

    fun decrypt(code: IntArray, k: Int): IntArray {
        val result = code.indices
            .map { i ->
                (0 until abs(k)).sumOf { code.safeGet(i + k.sign + k.sign * it) }
            }
        return result.toIntArray()
    }

    @Test
    fun testSafeGet() {
        intArrayOf(1, 2, 3, 4).apply {
            assertThat(safeGet(4)).isEqualTo(this[0])
            assertThat(safeGet(7)).isEqualTo(this[3])
            assertThat(safeGet(9)).isEqualTo(this[1])
            assertThat(safeGet(-1)).isEqualTo(this[3])
            assertThat(safeGet(-2)).isEqualTo(this[2])
            assertThat(safeGet(-3)).isEqualTo(this[1])
            assertThat(safeGet(-4)).isEqualTo(this[0])
        }
    }

    @Test
    fun example1() {
        assertThat(
            decrypt(intArrayOf(5, 7, 1, 4), 3)
        ).isEqualTo(intArrayOf(12, 10, 16, 13))
    }

    @Test
    fun example2() {
        assertThat(
            decrypt(intArrayOf(1, 2, 3, 4), 0)
        ).isEqualTo(intArrayOf(0, 0, 0, 0))
    }

    @Test
    fun example3() {
        assertThat(
            decrypt(intArrayOf(2, 4, 9, 3), -2)
        ).isEqualTo(intArrayOf(12, 5, 6, 13))
    }
}
