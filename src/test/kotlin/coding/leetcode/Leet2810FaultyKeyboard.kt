package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Leet2810FaultyKeyboard {

    fun finalString(s: String): String {
        var result = ""
        s.forEach{c ->
            if(c == 'i') {
                result = result.reversed()
            } else {
                result += c
            }
        }
        return result
    }

    @Test
    fun example1() {
        assertThat(finalString("string")).isEqualTo("rtsng")
    }

    @Test
    fun example2() {
        assertThat(finalString("poiinter")).isEqualTo("ponter")
    }

}