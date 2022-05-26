package coding.educative.patterns.bitwisexor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TwoSingleNumbers {

    fun List<Int>.missingTwo(): List<Int> {
        var n1xn2 = 0
        forEach { n ->
            n1xn2 = n1xn2.xor(n)
        }
        //println(n1xn2)

        var rightMostSetBit = 1
        while ((rightMostSetBit.and(n1xn2)) == 0) {
            rightMostSetBit = rightMostSetBit.shl(1)
        }

        var num1 = 0
        var num2 = 0
        val numbersWithSetBit = forEach { n ->
            if(rightMostSetBit.and(n) == 0) {
                num1 = num1.xor(n)
            } else {
                num2 = num2.xor(n)
            }
        }
        return listOf(num1, num2)
    }

    @Test
    fun example1() {
        assertThat(
            listOf(1, 4, 2, 1, 3, 5, 6, 2, 3, 5).missingTwo().also {println("Found $it")}
        ).isEqualTo(listOf(4, 6))
    }
}