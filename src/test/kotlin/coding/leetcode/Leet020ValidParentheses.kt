package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.util.*

fun Char.openParenthesis() =
    when(this) {
        ')' -> '('
        '}' -> '{'
        ']' -> '['
        else -> error("Not a close parenthesis")
    }

val Char.isOpen: Boolean
    get() = this in listOf('(', '{', '[')

fun isValid(s: String): Boolean {
    val stack: Stack<Char> = Stack()
    for (i in s.indices) {
        if (s[i].isOpen) {
            stack.push(s[i])
        } else {
            if(stack.isNotEmpty() && stack.peek() == s[i].openParenthesis()) {
                stack.pop()
            } else {
                return false
            }
        }
    }
    return stack.isEmpty()
}


class LeetCode020ValidParentesesTest {

    @CsvSource(
        value = [
            "(), true",
            "()[]{}, true",
            "(], false",
            "([({([({})])})])([({})]), true",
            "([({}))], false",
            "], false",
        ]
    )
    @ParameterizedTest
    fun examples(s: String, expectedResult: Boolean) {
        assertThat(isValid(s)).isEqualTo(expectedResult)
    }
}
