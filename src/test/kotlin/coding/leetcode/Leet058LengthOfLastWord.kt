package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

fun lengthOfLastWord(s: String): Int {
    return s.split(" ")
        .lastOrNull { it.isNotBlank() }
        ?.length ?: 0
}


class Leet058LengthOfLastWord {

    @Test
    fun example1() {
        assertThat(lengthOfLastWord("Hello World")).isEqualTo(5)
        assertThat(lengthOfLastWord("   fly me   to   the moon  ")).isEqualTo(4)
        assertThat(lengthOfLastWord("luffy is still joyboy")).isEqualTo(6)
        assertThat(lengthOfLastWord(" ")).isEqualTo(0)
    }

}