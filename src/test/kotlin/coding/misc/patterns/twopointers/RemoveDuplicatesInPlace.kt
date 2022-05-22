package coding.misc.patterns.twopointers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RemoveDuplicatesInPlace {

    fun removeDuplicates(arr: IntArray): Int {
        var lastInsertIndex = 0
        arr.indices.forEach { i ->
            if(arr[i] > arr[lastInsertIndex]) {
                lastInsertIndex++
                arr[lastInsertIndex] = arr[i]
            }
        }
        return lastInsertIndex+1
    }

    @Test
    fun example1() {
        val input = intArrayOf(2, 3, 3, 3, 6, 9, 9)
        val newLength = removeDuplicates(input)
        assertThat(newLength).isEqualTo(4)
        assertThat(input.toList().slice(0 until newLength)).isEqualTo(
            listOf(2, 3, 6, 9)
        )
    }

    @Test
    fun example2() {
        val input = intArrayOf(2, 2, 2, 11)
        val newLength = removeDuplicates(input)
        assertThat(newLength).isEqualTo(2)
        assertThat(input.toList().slice(0 until newLength)).isEqualTo(
            listOf(2, 11)
        )
    }

}