package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet2899LastVisitedIntegersTest {

    fun lastVisitedIntegers(words: List<String>): List<Int> {

        // "1","prev","2","prev","prev"
        val result = mutableListOf<Int>()
        val numbers = mutableListOf<Int>()
        var index = -1
        words.forEachIndexed {i,s ->
            if(s == "prev") {
                if(index < 0) {
                    result.add(-1)
                } else {
                    result.add(numbers[index])
                    index--
                }
            } else {
                numbers.add(s.toInt())
                index = numbers.size-1
            }
        }


        return result
    }

    @Test
    fun example1() {
        assertThat(
                lastVisitedIntegers(listOf("1","2","prev","prev","prev"))
        ).isEqualTo(listOf(2, 1, -1))
    }

    @Test
    fun example2() {
        assertThat(
                lastVisitedIntegers(listOf("1","prev","2","prev","prev"))
        ).isEqualTo(listOf(1,2,1))
    }

}