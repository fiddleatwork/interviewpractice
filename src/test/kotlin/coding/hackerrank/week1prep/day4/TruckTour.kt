package coding.hackerrank.week1prep.day4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TruckTour {

    @Test
    fun `example 1`() {
        assertThat(
            truckTour(
                arrayOf(
                    arrayOf(1, 5),
                    arrayOf(10, 3),
                    arrayOf(3, 4)
                )
            )
        ).isEqualTo(1)
    }

    @Test
    fun `my example 1`() {
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

    @Test
    fun `my example 2`() {
        assertThat(
            truckTour(
                arrayOf(
                    arrayOf(10, 3),
                    arrayOf(1, 5),
                    arrayOf(3, 4)
                )
            )
        ).isEqualTo(0)
    }

    @Test
    fun `my example 3`() {
        assertThat(
            truckTour(
                arrayOf(
                    arrayOf(1, 3),
                    arrayOf(1, 5),
                    arrayOf(1, 4)
                )
            )
        ).isEqualTo(-1)
    }

    @Test
    fun `my example 4`() {
        assertThat(
            truckTour(
                arrayOf(
                    arrayOf(3, 3),
                    arrayOf(5, 5),
                    arrayOf(4, 4)
                )
            )
        ).isEqualTo(0)
    }

    @Test
    fun `my example 5`() {
        assertThat(
            truckTour(
                arrayOf(
                    arrayOf(3, 3),
                    arrayOf(4, 5),
                    arrayOf(14, 5)
                )
            )
        ).isEqualTo(2)
    }

    // This code is not very pretty, for a more elegant but slower solution see TruckTourBetterDesign
    fun truckTour(petrolpumps: Array<Array<Int>>): Int {
        for (i in petrolpumps.indices) {
           // println("Starting index $i (station ${i+1})")
            var tank = 0
            var completed = true
            for (j in 0 until petrolpumps.size-1) {
                val index = if (i + j >= petrolpumps.size) {
                    i + j - petrolpumps.size
                } else {
                    i + j
                }
                tank += petrolpumps[index][0]
                if (tank < petrolpumps[index][1]) {
                    // failed
                    //println("\tCan't get to the next station from $index")
                    completed = false
                    break;
                } else {
                    tank -= petrolpumps[index][1]
                }
                //println("\tCan go to the next station from $index")
            }
            if (completed) {
                return i
            }
        }
        return -1
    }

}