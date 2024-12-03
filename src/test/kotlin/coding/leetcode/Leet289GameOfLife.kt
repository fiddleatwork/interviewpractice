package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

// https://leetcode.com/problems/game-of-life/description/

fun gameOfLife(board: Array<IntArray>) {
    val newBoard = board.map { it.clone() }.toTypedArray()
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == 0) {
                if (liveNeighbors(board, i, j) == 3) {
                    newBoard[i][j] = 1
                }
            } else if (board[i][j] == 1) {
                val liveNeighbors = liveNeighbors(board, i, j)
                if (liveNeighbors < 2) {
                    newBoard[i][j] = 0
                }
                if (liveNeighbors in listOf(2, 3)) {
                    newBoard[i][j] = 1
                }
                if (liveNeighbors > 3) {
                    newBoard[i][j] = 0
                }
            } else {
                throw IllegalStateException("Invalid board value at $i $j ${board[i][j]}")
            }
        }
    }
    copy(newBoard, board)
}

fun copy(source: Array<IntArray>, destination: Array<IntArray>) {
    for (i in source.indices) {
        for (j in source[i].indices) {
            destination[i][j] = source[i][j]
        }
    }
}

fun liveNeighbors(board: Array<IntArray>, x: Int, y: Int): Int {
    var result = 0
    for (i in -1..1) {
        for (j in  -1.. 1) {
            if(i == 0 && j == 0) {
                continue
            }
            if (x+i >= 0 && x+i < board.size && y+j >= 0 && y+j < board[x+i].size) {
                result += board[x+i][y+j]
            }
        }
    }
    return result
}

fun print(board: Array<IntArray>) {
    println("Board")
    for (i in board.indices) {
        for (j in board[i].indices) {
            print(board[i][j])
        }
        println()
    }
    println()
}

class GameOfLifeTest {

    @Test
    fun example1() {
        val board = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0)
        )
        val expectedBoard = arrayOf(
            intArrayOf(0, 0, 0), intArrayOf(1, 0, 1), intArrayOf(0, 1, 1), intArrayOf(0, 1, 0)
        )
        print(board)
        gameOfLife(board)
        print(board)
        assertThat(board).isEqualTo(expectedBoard)
    }

}