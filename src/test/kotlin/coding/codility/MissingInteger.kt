package coding.codility

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MissingInteger {

    private fun solution(A: IntArray): Int {
        //val map = mutableMapOf<Int, Boolean>()
        val map = A.associateWith { a -> true }
        (1 until 100000).forEach { n ->
            if(!map.containsKey(n)) {
                return n
            }
        }
        return 0

    }

    @Test
    fun example1() {
        assertThat(solution(intArrayOf(1, 3, 6, 4, 1, 2))).isEqualTo(5)
    }
}