package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.lang.Integer.max

class Leet121BestTimeToBuyAndSellStock {

    fun maxProfit(prices: List<Int>) =
        if (prices.size <= 1) {
            0
        } else {
            max(
                prices.dropLast(1).mapIndexed { i, n ->
                    prices.drop(i + 1).max() - n
                }.max(),
                0
            )
        }


    // fun maxProfit(prices: IntArray) = maxProfit(prices.toList())

    fun maxProfit(prices: IntArray): Int {
        var buyPrice = Int.MAX_VALUE
        var maxProfit = 0
        for (i in prices.indices) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i]
            }
            val profit = prices[i] - buyPrice
            if (maxProfit < profit) {
                maxProfit = profit
            }
        }
        return maxProfit
    }

    @Test
    fun example1() {
        assertThat(
            maxProfit(
                intArrayOf(
                    7, 1, 5, 3, 6, 4
                )
            )
        ).isEqualTo(5)
    }

    //  7, 1, 5, 3, 6, 4
    //  -6, 4, -2, 3, -2

    @Test
    fun example2() {
        assertThat(
            maxProfit(
                intArrayOf(
                    7, 6, 4, 3, 1
                )
            )
        ).isEqualTo(0)
    }

    @Test
    fun exampleBig() {
        val bigTestSet = (1..32000).map { (Math.random()*100).toInt()}
        assertThat(maxProfit(bigTestSet)).isEqualTo(99)
    }
}