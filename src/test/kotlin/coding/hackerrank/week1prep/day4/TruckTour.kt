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

    // My first attempt neglected the fact that the truck must go around in the circle in order and as a result
    // was overly complex and I didn't finish in the time limit.

//    @Test
//    fun `example 1`() {
//        assertThat(
//            truckTour(
//                Truck(0),
//                0,
//                listOf(
//                    PetrolStation(1, 5),
//                    PetrolStation(10, 3),
//                    PetrolStation(3, 4),
//                )
//            )
//        ).isEqualTo(0)
//    }
//
//    @Test
//    fun `my example 1`() {
//        assertThat(
//            truckTour(
//                Truck(0),
//                0,
//                listOf(
//                    PetrolStation(1, 2),
//                    PetrolStation(1, 1),
//                    PetrolStation(1, 1),
//                    PetrolStation(1, 1),
//                    PetrolStation(1, 1),
//                )
//            )
//        ).isEqualTo(1)
//    }
//
//    data class PetrolStation(
//        val amount: Int,
//        val nextDistance: Int
//    )
//
//    data class Truck(
//        val tank: Int
//    ) {
//        fun canMakeItToNext(station: PetrolStation): Boolean =
//            tank + station.amount > station.nextDistance
//
//        fun fillUpAndDriveToNext(station: PetrolStation): Truck =
//            copy(tank = tank + station.amount - station.nextDistance)
//    }
//
//    private fun truckTour(truck: Truck, startingStation: Int, stations: List<PetrolStation>): Int {
//        if(stations.isEmpty()) {
//            return startingStation
//        }
//        for(i in stations.indices) {
//            // consume station i & go to next station
//            if(truck.canMakeItToNext(stations[i])) {
//                val result = truckTour(truck.fillUpAndDriveToNext(stations[i]), i, stations.drop(1))
//                if(result > -1) {
//                    return i
//                }
//            }
//        }
//        return -1
//    }

//    private fun truckTour(truck: Truck, stations: List<PetrolStation>): Int {
//        for (i in stations.indices) {
//            // starting at i
//            // consume station i & go to next station
//            if (truck.canMakeItToNext(stations[i])) {
//                val result = truckTour(truck.fillUpAndDriveToNext(stations[i]), i, stations.drop(1))
//                if (result > -1) {
//                    return i
//                }
//            }
//        }
//        return -1
//    }

//    fun truckTour(petrolpumps: Array<Array<Int>>): Int {
//        return truckTour(Truck(0), petrolpumps.map { PetrolStation(it[0], it[1]) }) + 1
//    }
}