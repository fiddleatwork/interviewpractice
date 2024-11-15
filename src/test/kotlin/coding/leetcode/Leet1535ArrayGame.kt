package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

// Given an integer array arr of distinct integers and an integer k.
// A game will be played between the first two elements of the array (i.e. arr[0] and arr[1]). In
// each round of the game, we compare arr[0] with arr[1], the larger integer wins and remains at
// position 0, and the smaller integer moves to the end of the array. The game ends when an integer
// wins k consecutive rounds.
// Return the integer which will win the game.
// It is guaranteed that there will be a winner of the game.

// Example 1:
// Input: arr = [2,1,3,5,4,6,7], k = 2
// Output: 5
// Explanation: Let's see the rounds of the game:
// Round |       arr       | winner | win_count
//   1   | [2,1,3,5,4,6,7] | 2      | 1
//   2   | [2,3,5,4,6,7,1] | 3      | 1
//   3   | [3,5,4,6,7,1,2] | 5      | 1
//   4   | [5,4,6,7,1,2,3] | 5      | 2
// So we can see that 4 rounds will be played and 5 is the winner because it wins 2 consecutive
// games.

// Example 2:
// Input: arr = [3,2,1], k = 10
// Output: 3
// Explanation: 3 will win the first 10 rounds consecutively.

/**
 * Results in stack overflow :(
 */
fun gameRecursive(arr: List<Int>, k: Int, wins: MutableMap<Int, Int> = mutableMapOf()): Int {
    println("Game called with list $arr k: $k and wins $wins")
    if (wins.isNotEmpty()) {
        wins.maxBy { it.value }.also {
            if (it.value == k) {
                return it.key.also { println("Winner found $it") }
            }
        }
    }
    if (arr[0] < arr[1]) {
        wins[arr[1]] = wins.getOrDefault(arr[1], 0) + 1
        return gameRecursive(arr.drop(1) + listOf(arr[0]), k, wins)
    } else {
        wins[arr[0]] = wins.getOrDefault(arr[0], 0) + 1
        return gameRecursive(listOf(arr[0]) + arr.subList(2, arr.size) + listOf(arr[1]), k, wins)
    }
}

@Disabled("Recusive is not optimal for this problem")
class IntegerGameRecursiveTest {
    @Test
    fun example1() {
        assertThat(
            gameRecursive(listOf(2, 1, 3, 5, 4, 6, 7), 2)
        ).isEqualTo(5)
    }

    @Test
    fun example2() {
        assertThat(
            gameRecursive(listOf(3, 2, 1), 10)
        ).isEqualTo(3)
    }

    @Test
    fun bigK() {
        // Fails
        assertThat(
            gameRecursive(listOf(1, 11, 22, 33, 44, 55, 66, 77, 88, 99), 1000000000)
        ).isEqualTo(99)
    }

}

data class Winner(
    var number: Int = -1,
    var wins: Int = 0,
) {
    fun add(number: Int) {
        if (this.number == number) {
            wins++
        } else {
            this.number = number
            wins = 1
        }
    }
}

/**
 * The key is to realize that after going through each item of the list,
 * the bigger value will be at the first position.  So we don't need any more
 * iterations to know it is the winner.
 */
fun getWinner(arr: IntArray, k: Int): Int {
    val arrList = arr.toMutableList()
    val winner = Winner()
    for(i in 0..arrList.size) {
        // println("$arrList $winner")
        if (arrList[0] < arrList[1]) {
            winner.add(arrList[1])
            arrList.add(arrList.removeAt(0))
        } else {
            winner.add(arrList[0])
            arrList.add(arrList.removeAt(1))
        }
        if(winner.wins == k) {
            break;
        }
    }
    return winner.number.also { println("Winner is $it") }
}


class IntegerGameTest {
    @Test
    fun example1() {
        assertThat(
            getWinner(intArrayOf(2, 1, 3, 5, 4, 6, 7), 2)
        ).isEqualTo(5)
    }

    @Test
    fun example2() {
        assertThat(
            getWinner(intArrayOf(3, 2, 1), 10)
        ).isEqualTo(3)
    }

    @Test
    @Disabled("Takes a long time, run manually")
    fun bigK() {
        // Fails
        assertThat(
            getWinner(intArrayOf(1, 11, 22, 33, 44, 55, 66, 77, 88, 99), 1000000000)
        ).isEqualTo(99)
    }

}
