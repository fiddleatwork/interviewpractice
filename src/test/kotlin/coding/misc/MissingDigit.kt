package coding.misc

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * I got this question in a real interview and it was one of the harder questions I've had.
 * I couldn't come up with an algorithm so I struggled through it but I did get all the tests
 * to pass.  After the interview I solved it again and came up with a much more elegant solution.
 * I think this is a hard problem for a coding interview where you have about 40 minutes of time.
 *
 * I won't say the name of the company, but I did find this problme online at:
 * https://www.geeksforgeeks.org/find-the-missing-digit-x-from-the-given-expression/
 *
 */
fun missingDigit(str: String): String {

    // tokens: x,=,4,-,2
    // tokens: 2,-,4,=,x
    // tokens: 3x,+,12,=,46"
    val tokens = str.split(" ").moveXToLeftSide()
    println("tokens: $tokens")

    val operator = tokens[1]
    val rhs = calculateRightHandSide(operator, tokens)
    println("rhs: $rhs")
    return tokens.first().solveX(rhs.toString())

}

private fun calculateRightHandSide(operator: String, tokens: List<String>) =
    if (operator != "=") {
        // we have an operation on the left that we need to undo to isolate x
        val inverseOperators = mapOf(
            "/" to { a: Int, b: Int -> a * b },
            "*" to { a, b -> (a / b) },
            "+" to { a, b -> (a - b) },
            "-" to { a, b -> (a + b) },
        )
        inverseOperators[operator]!!(tokens[4].toInt(), tokens[2].toInt())
    } else {
        // tokens: x,=,4,-,2
        val operators = mapOf(
            "*" to { a: Int, b: Int -> a * b },
            "/" to { a, b -> (a / b) },
            "-" to { a, b -> (a - b) },
            "+" to { a, b -> (a + b) },
        )
        operators[tokens[3]]!!(tokens[2].toInt(), tokens[4].toInt())
    }

fun String.solveX(value: String): String {
    return value[indexOfFirst { it == 'x' }].toString()
}

fun List<String>.moveXToLeftSide(): List<String> {
    val equalsIndex = indexOfFirst { it == "=" }
    val xIndex = indexOfFirst { it.contains("x") }
    if (xIndex < equalsIndex) {
        return this
    }
    // tokens: 2,-,4,=,x
    // equalsIndex = 3
    // xIndex = 4
    return drop(equalsIndex + 1) + "=" + dropLast(size - equalsIndex)

}

class MissingDigitTest {

    @Test
    fun `flip tokens to put x on left side`() {
        assertThat(listOf("x", "=", "4", "-", "2").moveXToLeftSide()).isEqualTo(listOf("x", "=", "4", "-", "2"))
        assertThat(listOf("4", "-", "2", "=", "x").moveXToLeftSide()).isEqualTo(listOf("x", "=", "4", "-", "2"))
    }

    @Test
    fun `determine x`() {
        assertThat("3x".solveX("34")).isEqualTo("4")
        assertThat("1x0".solveX("100")).isEqualTo("0")
    }

    @Test
    fun `example 1`() {
        // 3x + 12 = 46
        // 3x = 46 - 12
        // 3x = 34
        // x = 4
        assertThat(missingDigit("3x + 12 = 46")).isEqualTo("4")
    }

    @Test
    fun `example 2a`() {
        // 4 - 2 = x
        // x = 4 - 2
        // x = 2
        assertThat(missingDigit("4 - 2 = x")).isEqualTo("2")
    }

    @Test
    fun `example 2b`() {
        // x = 4 - 2
        // x = 2
        assertThat(missingDigit("x = 4 - 2")).isEqualTo("2")
    }

    @Test
    fun `example 3`() {

        // 1x0 * 12 = 1200
        // 1x0 = 1200 / 12
        // 1x0 = 100
        // x = 0
        assertThat(missingDigit("1x0 * 12 = 1200")).isEqualTo("0")
    }
}
