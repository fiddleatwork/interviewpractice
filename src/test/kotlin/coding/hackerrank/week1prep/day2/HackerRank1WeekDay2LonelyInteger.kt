package coding.hackerrank.week1prep.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LonelyInteger {

    @Test
    fun `find lonely integer`() {
        assertThat(lonelyinteger(arrayOf(1, 2, 3, 4, 3, 2, 1))).isEqualTo(4)
        assertThat(lonelyinteger(arrayOf(1))).isEqualTo(1)
        assertThrows<RuntimeException> {
            lonelyinteger(arrayOf(1, 2, 3, 3, 2, 1))
        }
    }

    fun lonelyinteger(a: Array<Int>): Int {
        return a.groupBy { it }
            .map { it.value }
            .firstOrNull {
                it.size == 1
            }
            ?.first() ?: error("Lonely integer not found.")
    }

    fun main(args: Array<String>) {
        val n = readLine()!!.trim().toInt()
        val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
        val result = lonelyinteger(a)
        println(result)
    }

}

