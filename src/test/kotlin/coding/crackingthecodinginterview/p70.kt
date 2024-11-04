package coding.crackingthecodinginterview

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class P70 {

    @Test
    fun `permutations of small in big easy case`() {
        doTest("ab", "zabz", 1, ::numberOfPermutationsSmallInBig3)
    }

    @Test
    fun `permutations of small in big easy case with single letter repeating`() {
        doTest("aa", "zaaz", 1, ::numberOfPermutationsSmallInBig3)
    }

    @Test
    fun `permutations of small in big`() {
        doTest("aba", "zxabajdaabeiwbaaxzaba", 3, ::numberOfPermutationsSmallInBig3)
    }

    @Test
    fun `permutations of 4 char small in big`() {
        doTest("abab", "zxczaabbzxcxccxbbaaxcvcvcbabaxcvxcvasdfaabbds", 4, ::numberOfPermutationsSmallInBig3)
    }

    @Test
    @Disabled
    fun `permutations of large s`() {
//        doTest("abababababa", "ababababababababababababababababjsdfjababjaaabababababababbabbba", 4, ::numberOfPermutationsSmallInBig2)
        doTest(
            "abababababa",
            "ababababababababababababababababjsdfjababjaaabababababababbabbba",
            14,
            ::numberOfPermutationsSmallInBig3
        )
    }

    private fun doTest(
        small: String,
        big: String,
        expectedSize: Int,
        algo: (String, String) -> Map<String, List<Int>>,
    ) {
        val result = algo(small, big)
        println(big)
        println(small)
        println(result)
        assertThat(
            result
                .values
                .flatten()
                .size
        ).isEqualTo(expectedSize)
    }

    @Test
    fun `remove range`() {
        assertThat("ABC".removeRange(1..1)).isEqualTo("AC")
    }

    @Test
    fun `String permutations of empty String`() {
        assertThat("".permutations()).isEqualTo(emptyList<String>())
    }

    @Test
    fun `String permutations of character`() {
        assertThat("A".permutations()).isEqualTo(listOf("A"))
    }

    @Test
    fun `String permutations of 2 character string`() {
        assertThat("AB".permutations()).isEqualTo(listOf("AB", "BA"))
    }

    @Test
    fun `String permutations`() {
        assertThat("ABC".permutations()).containsExactlyInAnyOrder(
            "ABC", "ACB", "BAC", "BCA", "CBA", "CAB"
        )
    }

    @Test
    fun `String permutations2`() {
        assertThat("ABC".permutations2()).containsExactlyInAnyOrder(
            "ABC", "ACB", "BAC", "BCA", "CBA", "CAB"
        )
    }

    @Test
    @Disabled
    fun `String permutations3 perf`() {
        permutations3("adfjsjsdfjsdjfsdfjsdfjsd")
    }

    @Test
    @Disabled
    fun `String permutations2 perf`() {
        "adfjsjsdfjsdjfsdfjsdfjsd".permutations2()
    }

    @Test
    @Disabled
    fun `String permutations perf`() {
        "adfjsjsdfjsdjfsdfjsdfjsd".permutations()
    }

    @Test
    fun `String indexesOf`() {
        assertThat("zxabajdaabeiwbaaxzaba".indicesOf("aba")).isEqualTo(listOf(2, 18))
    }

    private fun String.indicesOf(s: String): List<Int> {
        val indices = mutableListOf<Int>()
        for (i in 0..length - s.length) {
            if (startsWith(s, i)) {
                indices.add(i)
                //println("Found $s at $i")
            }
        }
        return indices
    }

    @Test
    fun `should insert character into string`() {
        assertThat("abc".insert('d', 0)).isEqualTo("dabc")
        assertThat("abc".insert('d', 1)).isEqualTo("adbc")
        assertThat("abc".insert('d', 2)).isEqualTo("abdc")
        assertThat("abc".insert('d', 3)).isEqualTo("abcd")
    }

    private fun String.insert(c: Char, i: Int) =
        substring(0 until i) + c + substring(i)

    private fun permutations3(s: String): List<String> =
        when (s.length) {
            1 -> listOf(s)
            2 -> listOf(s, s.reversed())
            else -> {
                val lastChar = s.last()
                val permsAllButLast = permutations3(s.dropLast(1))
                permsAllButLast.flatMap { p ->
                    p.toCharArray()
                        .mapIndexed { i, _ ->
                            p.insert(lastChar, i)
                        } + (p + lastChar)
                }
            }
        }

    private fun String.permutations2(): List<String> =
        when (length) {
            1 -> listOf(this)
            2 -> listOf(this, this.reversed())
            else -> {
                val lastChar = last()
                val permsAllButLast = dropLast(1).permutations2()
                permsAllButLast.flatMap { p ->
                    p.toCharArray()
                        .mapIndexed { i, _ ->
                            p.insert(lastChar, i)
                        } + (p + lastChar)
                }
            }
        }

    private fun String.permutations(): List<String> =
        when {
            isEmpty() -> emptyList()
            length == 1 -> listOf(this)
            else -> {
                mapIndexed { i, c ->
                    val withoutI = removeRange(i..i)
                    withoutI.permutations().map { c + it }
                }
                    .flatten()
                    .distinct()
            }
        }

    private fun numberOfPermutationsSmallInBig(small: String, big: String) =
        small.permutations()
            .associateWith { big.indicesOf(it) }
            .also {
                println(it)
            }

    private fun String.structure() =
        toCharArray().associate { c -> c.toString() to count { it == c } }
            .toSortedMap()

    @Test
    fun `test letterCount`() {
        assertThat("babaabbb".structure()).isEqualTo(
            mapOf(
                "a" to 3,
                "b" to 5,
            )
        )
    }

    fun String.allSubstrings(size: Int): List<String> =
        toCharArray().mapIndexed { i, c ->
            println("Checking $this $size $i $c")
            if (i <= length - size) substring(i..i + size) else null
        }
            .filterNotNull()

    @Test
    fun `test allSubstrings`() {
        // TODO fix failing test
        assertThat("abc".allSubstrings(1)).isEqualTo(listOf("a", "b", "c"))
        assertThat("ABCDE".allSubstrings(3)).isEqualTo(listOf("ABC", "BCD", "CDE"))
    }

    private fun numberOfPermutationsSmallInBig2(small: String, big: String): Map<String, List<Int>> {
        val smallStructure = small.structure()
//        for(i in 0)
        return big.toCharArray()
            .map { c -> c.toString() }
            .mapIndexed { i, _ ->
                if (i < big.length - small.length && smallStructure == big.substring(i until i + small.length)
                        .structure()
                ) {
                    i
                } else {
                    null
                }
            }
            .filterNotNull()
            .let {
                mapOf(small to it)
            }
    }

    private fun numberOfPermutationsSmallInBig3(small: String, big: String): Map<String, List<Int>> {
        val smallPermutations = small.permutations().associateWith { true }.toSortedMap()
        return big.toCharArray()
            .map { c -> c.toString() }
            .mapIndexed { i, _ ->
                if (i < big.length - small.length && smallPermutations[big.substring(i until i + small.length)] == true) {
                    i
                } else {
                    null
                }
            }
            .filterNotNull()
            .let {
                mapOf(small to it)
            }
    }


//    fun main() {
//        println(subSet(listOf("a", "b", "c", "d")))
//    }
//
//    fun subSet(s: List<String>): List<String>{
//        return createSubSets(s, 0, emptyList())
//    }
//
//    tailrec fun createSubSets(s: List<String>, index: Int, carryOn: List<String>): List<String> {
//        if (index > s.lastIndex) {
//            return carryOn
//        }
//        val otherElements = s.subList(0, index) + s.subList(index + 1, s.size)
//        val element = s[index]
//        return createSubSets(s, index + 1, carryOn + otherElements.map { element + it })
//    }

// [ab, ac, ad, ba, bc, bd, ca, cb, cd, da, db, dc]

}