package coding.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class Leet036ValidSudokuTest {

    fun checkLine(line: List<String>) : Boolean {
        if(line.any {it != "." && (it < "0" || it > "9")}) {
            // has non-number
            return false
        }
        if(line.filterNot {it == "."}
            .groupBy {it}.values.any {it.size > 1}) {
            // duplicate
            return false
        }
        return true
    }

    // Obviously not optimal but out of time for now, will revisit later
    fun checkMiniSquare(board: Array<CharArray>, r: Int, c: Int, size: Int): Boolean {
        val line = listOf(
            board[r][c],
            board[r][c+1],
            board[r][c+2],
            board[r+1][c],
            board[r+1][c+1],
            board[r+1][c+2],
            board[r+2][c],
            board[r+2][c+1],
            board[r+2][c+2],
        ).map {it.toString()}
        return checkLine(line)
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // check row
        board.indices.forEach { r ->
            if(!checkLine(board[r].toList().map{it.toString()})) {
                return false
            }
        }

        // check column
        for(c in board.indices) {
            val column = board.indices.fold(emptyList<String>()) {acc, r ->
                acc + board[r][c].toString()
            }
            if(!checkLine(column)) {
                return false
            }
        }

        // check mini square
        if(
            listOf(
                checkMiniSquare(board, 0,0,3),
                checkMiniSquare(board, 0,3,3),
                checkMiniSquare(board, 0,6,3),
                checkMiniSquare(board, 3,0,3),
                checkMiniSquare(board, 3,3,3),
                checkMiniSquare(board, 3,6,3),
                checkMiniSquare(board, 6,0,3),
                checkMiniSquare(board, 6,3,3),
                checkMiniSquare(board, 6,6,3),
            ).none()
        ) {
            return false
        }
        return true
    }


    @Test
    fun testValidSudoku1() {
        val board = arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')


        )
        assertTrue(isValidSudoku(board))
    }

    @Test
    fun testInvalidSudoku2() {
        val board = arrayOf(
            charArrayOf('8','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
        )
        assertFalse(isValidSudoku(board))
    }

    @Test
    fun testFailingCase1() {
        val board = arrayOf(
            charArrayOf('.', '.', '.', '.', '5', '.', '.', '1', '.'),
            charArrayOf('.', '4', '.', '3', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '3', '.', '.', '1'),
            charArrayOf('8', '.', '.', '.', '.', '.', '.', '2', '.'),
            charArrayOf('.', '.', '2', '.', '7', '.', '.', '.', '.'),
            charArrayOf('.', '1', '5', '.', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '.', '.', '.', '2', '.', '.', '.'),
            charArrayOf('.', '2', '.', '9', '.', '.', '.', '.', '.'),
            charArrayOf('.', '.', '4', '.', '.', '.', '.', '.', '.')
        )
        assertFalse(isValidSudoku(board))
    }
}