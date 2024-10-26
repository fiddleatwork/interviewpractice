package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.math.max

//Given two version strings, version1 and version2, compare them. A version string consists of revisions separated by dots '.'. The value of the revision is its integer conversion ignoring leading zeros.
//
//To compare version strings, compare their revision values in left-to-right order. If one of the version strings has fewer revisions, treat the missing revision values as 0.
//
//Return the following:
//
//If version1 < version2, return -1.
//If version1 > version2, return 1.
//Otherwise, return 0.
//
//Constraints:
//
//1 <= version1.length, version2.length <= 500
//version1 and version2 only contain digits and '.'.
//version1 and version2 are valid version numbers.
//All the given revisions in version1 and version2 can be stored in a 32-bit integer.


fun List<Int>.padEnd(length: Int) : List<Int> {
    if (size >= length) {
        return this
    }
    return this + List(length-size) {0}
}

fun compareVersion(version1: String, version2: String): Int {
    val v1Tokens = version1.split(".").map { it.toInt() }
    val v2Tokens = version2.split(".").map { it.toInt() }
    val maxLength = max(v1Tokens.size, v2Tokens.size)
    v1Tokens.padEnd(maxLength)
        .zip(v2Tokens.padEnd(maxLength))
        .forEach {
            it.first.compareTo(it.second).also { compare ->
                if (compare != 0) {
                    return compare
                }
            }
        }
    return 0
}

class Leet165CompareVersionNumbersTest {

    @Test
    fun example1() {
        assertThat(compareVersion(version1 = "1.2", version2 = "1.10")).isEqualTo(-1)
    }

    @Test
    fun example2() {
        assertThat(compareVersion(version1 = "1.01", version2 = "1.001")).isEqualTo(0)
    }

    @Test
    fun example3() {
        assertThat(compareVersion(version1 = "1.0", version2 = "1.0.0.0")).isEqualTo(0)
    }

    @Test
    fun myExample1() {
        assertThat(compareVersion(version1 = "1.0.1", version2 = "1.1.0")).isEqualTo(-1)
        assertThat(compareVersion(version1 = "1.1.0", version2 = "1.0.1")).isEqualTo(1)
    }

    @Test
    fun `one shorter than the other`() {
        assertThat(compareVersion(version1 = "1.0.1", version2 = "1.0.1.2")).isEqualTo(-1)
    }

    @Test
    fun padEnd() {
        assertThat(listOf(1,2).padEnd(4)).isEqualTo(listOf(1,2,0,0))
    }

}