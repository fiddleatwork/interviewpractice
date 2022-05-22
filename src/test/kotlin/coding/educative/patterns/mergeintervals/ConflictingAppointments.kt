package coding.educative.patterns.mergeintervals

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConflictingAppointments {

    data class Interval(
        val start : Int,
        val end: Int,
    )

    fun List<Interval>.conflicts() : Boolean {
        if(size <= 1) {
            return false
        }
        val sorted = sortedBy { it.start }
        for(i in 1 until sorted.size) {
            if (sorted[i].start < sorted[i - 1].end)
                return true
        }
        return false
    }

    @Test
    fun `detect conflict`() {
        assertThat(
            listOf(Interval(1,4), Interval(2,5), Interval(7,9)).conflicts()
        ).isTrue
    }

    @Test
    fun `no conflict`() {
        assertThat(
            listOf(Interval(6,7), Interval(2,4), Interval(8,12)).conflicts()
        ).isFalse
    }

}
