package coding.hackerrank.week1prep.day3

import kotlin.Throws
import kotlin.jvm.JvmStatic
import coding.hackerrank.week1prep.day3.ZigZagSequence
import org.junit.jupiter.api.Test
import java.lang.Exception
import java.util.*

class ZigZagSequence {
    @Test
    fun testCase0() {
        findZigZagSequence(intArrayOf(1, 2, 3, 4, 5, 6, 7), 7);
    }

    fun findZigZagSequence(a: IntArray, n: Int) {
        Arrays.sort(a)
        val mid = ((n + 1) / 2)-1
        var temp = a[mid]
        a[mid] = a[n - 1]
        a[n - 1] = temp
        var st = mid + 1
        var ed = n - 1-1
        while (st <= ed) {
            temp = a[st]
            a[st] = a[ed]
            a[ed] = temp
            st += 1
            ed -= 1
        }
        for (i in 0 until n) {
            if (i > 0) print(" ")
            print(a[i])
        }
        println()
    }
}
