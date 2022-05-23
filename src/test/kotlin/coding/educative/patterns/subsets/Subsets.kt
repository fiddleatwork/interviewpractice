package coding.educative.patterns.subsets

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Subsets {

    private fun Set<Int>.subsets() : Set<Set<Int>> {
        val results = mutableSetOf(mutableSetOf<Int>())
        forEach {i ->
            println("Before\ti = $i  results = $results")
            val newResults = mutableSetOf(mutableSetOf<Int>())
            results.forEach { s ->
                val copy = LinkedHashSet(s)
                copy.add(i)
                newResults.add(copy)
                println("\ti = $i  s=$s results = $results newResults = $newResults")
            }
            results.addAll(newResults)
            println("After\ti = $i  results = $results")
        }
        return results
    }

    @Test
    fun example2() {
        assertThat(
            setOf(1,5,3).subsets()
        ).containsExactlyInAnyOrder(
            emptySet(), setOf(1), setOf(3), setOf(5), setOf(1,5), setOf(1,3), setOf(3,5), setOf(1,3,5)
        )
    }

}