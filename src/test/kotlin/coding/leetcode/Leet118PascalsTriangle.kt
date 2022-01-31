package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

fun nextRowOfPascal(row: List<Int>): List<Int> {
//    val withZeros = listOf(0) + row + 0
//    for (i in 0..withZeros.size - 2) {
//
//    }
    //[0, 1, 3, 3, 1, 0]
    //<0,1>, <1,3>, <3,3>
    return (listOf(0) + row + 0).zipWithNext()
        .map {it.first + it.second}
}

fun generate(numRows: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val start = listOf(1)
    result.add(start)
    for(i in 0..numRows-2) {
        result.add(nextRowOfPascal(result.last()))
    }
    return result
}


class Leet118PascalsTriangleTest {

    @Test
    fun example1() {
        assertThat(generate(5)).isEqualTo(
            listOf(
                listOf(1),
                listOf(1, 1),
                listOf(1, 2, 1),
                listOf(1, 3, 3, 1),
                listOf(1, 4, 6, 4, 1),
            )
        )
    }
}





