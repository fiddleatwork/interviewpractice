package coding.modifiedbinarysearch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OrderAgnosticBinarySearch {

    private fun List<Int>.searchIndexOf(k: Int): Int {
        if (isEmpty()) {
            return -1
        }
        return when (first().compareTo(last())) {
            1 -> size - 1 - reversed().searchIndexOf(k)
            else -> searchIndexOfHelper(k)
        }
    }

    private fun List<Int>.searchIndexOfHelper(k: Int): Int {
        if (isEmpty()) {
            return -1
        }
        val start = size / 2
        return when {
            k == get(start) -> return start
            k < get(start) -> slice(0 until start).searchIndexOf(k)
            else -> slice(start + 1 until size).searchIndexOf(k) + start + 1
        }
    }

    @Test
    fun example2() {
        assertThat(
            listOf(1, 2, 3, 4, 5, 6, 7).searchIndexOf(5)
        ).isEqualTo(4)
    }

    @Test
    fun bigExample() {
        val list = List(100) { it + 1 }
        assertThat(list.searchIndexOf(33)).isEqualTo(32)
        assertThat(list.searchIndexOf(88)).isEqualTo(87)
        assertThat(list.searchIndexOf(0)).isEqualTo(-1)
        assertThat(list.searchIndexOf(1)).isEqualTo(0)
        assertThat(list.searchIndexOf(100)).isEqualTo(99)
    }

    @Test
    fun `handle duplicates`() {
        assertThat(
            listOf(1, 1, 2, 3, 3, 4, 5, 6, 7).searchIndexOf(2)
        ).isEqualTo(2)
    }

    @Test
    fun `handle sorted descending`() {
        assertThat(
            listOf(7, 6, 5, 4, 3, 2, 1).searchIndexOf(5)
        ).isEqualTo(2)
    }
}