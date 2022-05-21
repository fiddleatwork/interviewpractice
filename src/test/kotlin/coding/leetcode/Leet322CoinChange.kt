package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet322CoinChange {

    // for BFTD
    val cache = mutableMapOf<Pair<Int, Int>, Int>()

    fun coinChange(coins: IntArray, amount: Int): Int {
        val default = amount + 1
        val dp = (1..amount).associateWith { default }.toMutableMap()
        dp[0] = 0
        (1..amount).forEach { a ->
            coins.forEach { c ->
                if (a - c >= 0) {
                    dp[a] = Math.min(dp[a]!!, 1 + dp[a - c]!!)
                }
            }
        }
        //println("coins = ${coins.toList()}  DP = ${dp.filterValues { it < default }}")
        return dp[amount]!!.let{
            if(it == default) {
                -1
            } else {
                it
            }
        }
    }

    fun coinChangeBruteForceTopDown(coins: IntArray, amount: Int): Int {
        return coinChangeBruteForceTopDown(coins, amount, 0).let {
            if (it == Int.MAX_VALUE) {
                -1
            } else {
                it
            }
        }
    }

    fun coinChangeBruteForceTopDown(coins: IntArray, amount: Int, count: Int): Int {
        if (cache.contains(Pair(amount, count))) {
            return cache[Pair(amount, count)]!!
        }
        if (amount <= 0) {
            return count
        }
        return coins
            .map { c ->
                val newAmount = amount - c
                if (newAmount < 0) {
                    Int.MAX_VALUE
                } else {
                    coinChangeBruteForceTopDown(coins, newAmount, count + 1)
                }
            }
            .minOrNull()!!
            .also {
                //println("Got $it coins for $amount")
                cache[Pair(amount, count)] = it
//                println("Cache $cache")
            }
    }

    fun coinChangeGreedy(coins: IntArray, amount: Int): Int {
        if (coins.isEmpty()) {
            return -1
        }
        val sortedCoins = coins.sorted()
        var coinCount = 0
        var a = amount
        for (i in coins.size - 1 downTo 0) {
            val howMany = a / sortedCoins[i]
            coinCount += howMany
            a -= howMany * sortedCoins[i]
            if (a == 0) {
                break
            }
        }
        if (a != 0) {
            return -1
        }
        return coinCount
    }

    @Test
    fun example1() {
        assertThat(
            coinChange(
                intArrayOf(1, 2, 5), 11
            )
        ).isEqualTo(3)
    }

    @Test
    fun example2() {
        assertThat(
            coinChange(
                intArrayOf(2), 3
            )
        ).isEqualTo(-1)
    }

    @Test
    fun example3() {
        assertThat(
            coinChange(
                intArrayOf(1), 0
            )
        ).isEqualTo(0)
    }

    @Test
    fun test1() {
        assertThat(
            coinChange(
                intArrayOf(186, 419, 83, 408), 6249
            )
        ).isEqualTo(20)
    }

    @Test
    fun `greedy no work`() {
        assertThat(
            coinChange(
                intArrayOf(1, 3, 4, 5), 7
            )
        ).isEqualTo(2)
    }


    @Test
    fun `tle`() {
        assertThat(
            coinChange(
                intArrayOf(3, 7, 405, 436), 8839
            )
        ).isEqualTo(25)
    }

}