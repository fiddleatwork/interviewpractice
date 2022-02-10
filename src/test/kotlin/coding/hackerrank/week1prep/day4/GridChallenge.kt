package coding.hackerrank.week1prep.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GridChallenge {

    @Test
    fun `example case yes`() {
        assertThat(
            gridChallenge(arrayOf("ebacd", "fghij", "olmkn", "trpqs", "xywuv"))
        ).isEqualTo("YES")
    }

    @Test
    fun `example case no`() {
        assertThat(
            gridChallenge(arrayOf("zbacd", "fghij", "olmkn", "trpqs", "xywuv"))
        ).isEqualTo("NO")
    }

    // Note the problem statements says the grid is square but in the test cases
    // that's not the case!
    @Test
    fun `example case invalid line length`() {
        assertThat(
            gridChallenge(arrayOf("abc", "hjk", "mpq", "rtv"))
        ).isEqualTo("YES")
    }

// ======================================================================

    private fun gridChallenge(grid: Array<String>) =
        grid.map { r ->
            r.toCharArray()
                .sorted()
                .joinToString("") { it.toString() }
        }
            .isSortedByColumn()
            .let {
                if (it) "YES" else "NO"
            }

    private fun List<String>.isSortedByColumn(): Boolean {
        for (c in 0 until first().length) {
            for (r in 0 until size - 1) {
                if (this[r][c] > this[r + 1][c]) {
                    return false
                }
            }
        }
        return true
    }
}

