package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CountingSort1 {

    @Test
    fun `test case 1`() {
        assertThat(
            countingSort(
                arrayOf(1, 1, 3, 2, 1)
            ).sliceArray(0 until 4)
        ).isEqualTo(arrayOf(0, 3, 1, 1))
    }

    fun countingSort(arr: Array<Int>): Array<Int> {
        val countArray = Array(100) { 0 }
        arr.forEach { a -> countArray[a] = countArray[a] + 1 }
        return countArray
    }

}

