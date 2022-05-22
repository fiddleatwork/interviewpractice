package coding.educative.patterns.cyclicsort

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CyclicSort {

    fun IntArray.cyclicSort() : IntArray {
        indices.forEach { i ->
            while(get(i) != i+1) {
                val temp = get(i)
                set(i, get(temp-1))
                set(temp-1, temp)
            }
        }
        return this
    }


    @Test
    fun example1() {
        assertThat(
            intArrayOf(3, 1, 5, 4, 2).cyclicSort()
        ).isEqualTo(
            intArrayOf(1, 2, 3, 4, 5)
        )
    }

    @Test
    fun example2() {
        assertThat(
            intArrayOf(2, 6, 4, 3, 1, 5).cyclicSort()
        ).isEqualTo(
            intArrayOf(1, 2, 3, 4, 5, 6)
        )
    }

    @Test
    fun example3() {
        assertThat(
            intArrayOf(1, 5, 6, 4, 3, 2).cyclicSort()
        ).isEqualTo(
            intArrayOf(1, 2, 3, 4, 5, 6)
        )
    }

}