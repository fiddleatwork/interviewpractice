package coding.educative.patterns.twoheaps

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class MedianOfAStream2 {

    // lower half
    val maxHeap = PriorityQueue { a: Int, b: Int -> b - a }

    // higher half
    val minHeap = PriorityQueue { a: Int, b: Int -> a - b }

    fun insert(n: Int) {
        if (maxHeap.isEmpty() || n <= maxHeap.peek()) {
            maxHeap.add(n)
        } else {
            minHeap.add(n)
        }

        if(maxHeap.size > minHeap.size+1) {
            minHeap.add(maxHeap.poll())
        } else if(minHeap.size > maxHeap.size) {
            maxHeap.add(minHeap.poll())
        }
    }

    fun median() : Double {
        return if(maxHeap.size == minHeap.size) {
            (maxHeap.peek() + minHeap.peek())/2.0
        } else {
            maxHeap.peek().toDouble()
        }
    }

}

class MedianOfStreamTest {

    @Test
    fun `calculate median`() {
        val m = MedianOfAStream2()
        m.insert(3)
        println("maxHeap ${m.maxHeap} minHeap ${m.minHeap}")
        m.insert(1)
        println("maxHeap ${m.maxHeap} minHeap ${m.minHeap}")
        assertThat(m.median()).isEqualTo(2.0)
        m.insert(5)
        println("maxHeap ${m.maxHeap} minHeap ${m.minHeap}")
        assertThat(m.median()).isEqualTo(3.0)
        m.insert(4)
        println("maxHeap ${m.maxHeap} minHeap ${m.minHeap}")
        assertThat(m.median()).isEqualTo(3.5)
    }

}