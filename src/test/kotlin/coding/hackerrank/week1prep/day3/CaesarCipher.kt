package coding.hackerrank.week1prep.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CaesarCipher {

    @Test
    fun `example 1`() {
        assertThat(caesarCipher("There's-a-starman-waiting-in-the-sky", 3))
            .isEqualTo("Wkhuh'v-d-vwdupdq-zdlwlqj-lq-wkh-vnb")
    }

    @Test
    fun `my example empty`() {
        assertThat(caesarCipher("", 3)).isEqualTo("")
    }

    @Test
    fun `my example plus 3`() {
        assertThat(caesarCipher("abcxyzABCXYZ.", 3)).isEqualTo("defabcDEFABC.")
    }

    @Test
    fun `my example minus 3`() {
        assertThat(caesarCipher("abcxyzABCXYZ.", -3)).isEqualTo("xyzuvwXYZUVW.")
    }

    @Test
    fun `my example 0`() {
        assertThat(caesarCipher("abcxyzABCXYZ.", 0)).isEqualTo("abcxyzABCXYZ.")
    }

    @Test
    fun `test wrap twice`() {
        assertThat(caesarCipher("Z", 27)).isEqualTo("A")
    }

    @Test
    fun `test case 10`() {
        assertThat(caesarCipher("1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M", 27))
            .isEqualTo("1Y7U4WsDt23l4ww08E6zR3T19H4sWQ188N9bivyC6k1uNHAt1n10fz7fVk62XW2fyMU4D83am7R80N")

        assertThat(caesarCipher("1X7T4VrCs23k4vv08D6yQ3S19G4rVP188M9ahuxB6j1tMGZs1m10ey7eUj62WV2exLT4C83zl7Q80M", 27))
            .isEqualTo("1Y7U4WsDt23l4ww08E6zR3T19H4sWQ188N9bivyC6k1uNHAt1n10fz7fVk62XW2fyMU4D83am7R80N")
    }

    private val alphabetSize = 'z'.code - 'a'.code + 1

    private fun caesarCipher(s: String, k: Int): String {
        var shift = k
        while(shift > alphabetSize) {
           shift -= alphabetSize
        }
        return s.map { c ->
            when (c) {
                in 'a'..'z' -> encryptChar(c, shift, 'a', 'z')
                in 'A'..'Z' -> encryptChar(c, shift, 'A', 'Z')
                else -> c
            }
        }
            .joinToString("") { it.toString() }
    }

    private fun encryptChar(c: Char, k: Int, wrapBegin: Char, wrapEnd: Char) =
        (c.code + k).let { i ->
            when {
                i < wrapBegin.code -> (i + alphabetSize).toChar()
                i > wrapEnd.code -> (i - alphabetSize).toChar()
                else -> i.toChar()
            }
        }
}
