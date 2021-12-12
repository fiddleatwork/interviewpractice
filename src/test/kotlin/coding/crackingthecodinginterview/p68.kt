package coding.crackingthecodinginterview

import org.junit.jupiter.api.Test
import java.lang.Math.cbrt
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow


class P68 {


    @Test
    fun `find solutions`() {
        solutions2()
    }

    fun Double.round(places: Int): Double {
        require(places >= 0)
        var bd = BigDecimal.valueOf(this)
        bd = bd.setScale(places, RoundingMode.HALF_UP)
        return bd.toDouble()
    }

    val cache = mutableMapOf<Double, MutableList<Pair<Int, Int>>>()

    fun solutions2() {
        val start = System.currentTimeMillis()
        val range = 1..1000
        for (a in range) {
            for (b in range) {
                val sum = a.toDouble().pow(3) + b.toDouble().pow(3)
                if(cache.containsKey(sum)) {
                    cache[sum]!!.add(Pair(a, b))
                } else {
                    cache[sum] = mutableListOf(Pair(a, b))
                }
            }
        }
        cache.keys.forEach {k ->
            val pairs = cache[k]!!
            pairs.forEach {p ->
                val pairs2 = cache[k]!!
                pairs2.forEach{p2 ->
                    println("${p.first} ${p.second} ${p2.first} ${p2.second}")
                }
            }
        }
//        val pairs = cache.values

//        for (a in range) {
//            for (b in range) {
//                val sum = a.toDouble().pow(3) + b.toDouble().pow(3)
//                if (cache.contains(sum)) {
//                    val pairs = cache[sum]!!
//                    pairs.forEach {
//                        println("$a $b ${it.first} ${it.second}")
//                    }
//                }
//            }
//        }
        println("Took ${System.currentTimeMillis() - start} milliseconds")
    }

    // a^3 + b^3 - c^3 = d^3
    fun solutions(){
        val start = System.currentTimeMillis()
        val range = 1..1000
        for (a in range) {
            for (b in range) {
                for (c in range) {
                    val d = cbrt(a.toDouble().pow(3.0) + b.toDouble().pow(3.0) - c.toDouble().pow(3.0)).toInt()
                    if (a.toDouble().pow(3) + b.toDouble().pow(3) == c.toDouble().pow(3) + d.toDouble().pow(3)) {
                        println("$a $b $c $d")
                    }
                }
            }
        }
        println("Took ${System.currentTimeMillis() - start} milliseconds")
    }
}