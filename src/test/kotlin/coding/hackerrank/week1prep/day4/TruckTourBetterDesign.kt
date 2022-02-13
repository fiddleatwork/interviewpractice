package coding.hackerrank.week1prep.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

/**
 * This solution uses a better design but it doesn't pass their performance test (too slow).
 */
class TruckTourBetterDesign {

    @Test
    fun `example 1`() {
        assertThat(
            truckTour(
                Truck(0),
                listOf(
                    PetrolStation(1, 5),
                    PetrolStation(10, 3),
                    PetrolStation(3, 4),
                )
            )
        ).isEqualTo(1)
    }

    @Test
    fun `my example 1`() {
        assertThat(
            truckTour(
                Truck(0),
                listOf(
                    PetrolStation(1, 2),
                    PetrolStation(1, 1),
                    PetrolStation(1, 1),
                    PetrolStation(1, 1),
                    PetrolStation(1, 1),
                )
            )
        ).isEqualTo(1)
    }

    @Test
    fun `should create sliding window that wraps around`() {
        assertThat(
            listOf(0, 1, 2, 3).slidingWindow(2)
        ).isEqualTo(
            listOf(2, 3, 0, 1)
        )
    }

    @Test
    fun `should return original list if starting at beginning`() {
        assertThat(
            listOf(0, 1, 2, 3).slidingWindow(0)
        ).isEqualTo(
            listOf(0, 1, 2, 3)
        )
    }

    @Test
    fun `test using their interface`() {
        assertThat(
            truckTour(
                arrayOf(
                    arrayOf(1, 5),
                    arrayOf(3, 4),
                    arrayOf(10, 3)
                )
            )
        ).isEqualTo(2)
    }

    /**
     * @return the list starting with the start index and wrapping to beginning so that it contains all elements
     */
    private fun <T> List<T>.slidingWindow(start: Int): List<T> {
        return subList(start, size) + if (start > 0) subList(0, start) else emptyList()
    }

    data class PetrolStation(
        val amount: Int,
        val nextDistance: Int
    )

    data class Truck(
        val tank: Int
    ) {
        fun canContinueFromStation(station: PetrolStation): Boolean =
            tank + station.amount >= station.nextDistance

        fun fillUpAndDriveToNext(station: PetrolStation): Truck =
            copy(tank = tank + station.amount - station.nextDistance)
    }

    private fun truckTour(truck: Truck, stations: List<PetrolStation>): Int {
        (stations.indices)
            .forEach { i ->
                if (canCompleteTour(truck, stations.slidingWindow(i))) {
                    return i
                }
            }
        return -1
    }

    private fun canCompleteTour(truck: Truck, stations: List<PetrolStation>): Boolean {
        return if (stations.size == 1) {
            true
        } else {
            if (truck.canContinueFromStation(stations.first())) {
                canCompleteTour(truck.fillUpAndDriveToNext(stations.first()), stations.drop(1))
            } else {
                false
            }
        }
    }

    fun truckTour(petrolpumps: Array<Array<Int>>): Int =
        truckTour(
            Truck(0),
            petrolpumps.map { PetrolStation(it[0], it[1]) }
        )
}