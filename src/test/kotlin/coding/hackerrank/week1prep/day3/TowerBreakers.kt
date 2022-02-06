package coding.hackerrank.week1prep.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TowerBreakers {

    @Test
    fun `example1`() {
        assertThat(towerBreakers(2, 6)).isEqualTo(2)
    }

    @Test
    fun `should return empty list when no more moves`() {
        assertThat(Tower(1).availableMoves()).isEmpty()
    }

    data class Tower(
        val height: Int,
    ) {
        fun availableMoves(): List<Tower> =
            (1 until height)
                .filter { height % it == 0 }
                .map { Tower(it) }
    }

    private fun Int.otherPlayer() = if (this == 1) 2 else 1

    private fun towerBreakers(level: Int, turn: Int, towers: List<Tower>): Int {
        val prefix = (0 until level).map { "\t" }.joinToString("") { it }
        println("$prefix towerBreaks level $level turn $turn towers $towers")
        val result = towers.flatMapIndexed { i, t ->
            val availableMoves = t.availableMoves()
            println("$prefix Available moves for tower $i are $availableMoves")
//            if (availableMoves.isEmpty()) return turn.otherPlayer()
            availableMoves.map { amt ->
                towerBreakers(level + 1, turn.otherPlayer(), listOf(amt) + towers.filter { it == t })
            }
        }.any { it == turn }
        return if (result) {
            turn
        } else {
            turn.otherPlayer()
        }
    }

    private fun towerBreakers(n: Int, m: Int): Int {
        //return towerBreakers(1, 1, (0 until n).map { Tower(m) })
        return if (m == 1 || (n % 2 == 0)) 2 else 1
    }

    fun main(args: Array<String>) {
        val t = readLine()!!.trim().toInt()

        for (tItr in 1..t) {
            val first_multiple_input = readLine()!!.trimEnd().split(" ")

            val n = first_multiple_input[0].toInt()

            val m = first_multiple_input[1].toInt()

            val result = towerBreakers(n, m)

            println(result)
        }
    }

}