package coding.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.math.abs
import kotlin.math.max

class LeetCode628MaxProduct3Numbers {

    fun maximumProduct(nums: IntArray): Int {
        val sorted = nums.sorted()
        return Math.max(
            sorted[0] * sorted[1] * sorted.last(),
            sorted.subList(nums.size-3, nums.size).fold(1) { acc, n -> acc * n }
        )
    }


    fun maximumProductHeap(nums: IntArray): Int {
        val minHeap = PriorityQueue<Int> { a, b -> a - b }
        val maxHeap = PriorityQueue<Int> { a, b -> b - a }
        (0 until 3).forEach { i ->
            minHeap.add(nums[i])
        }
        (0 until 2).forEach { i ->
            maxHeap.add(nums[i])
        }
        (3 until nums.size).forEach { i ->
            if (nums[i] > minHeap.peek()) {
                minHeap.poll()
                minHeap.add(nums[i])
            }
        }
        (2 until nums.size).forEach { i ->
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll()
                maxHeap.add(nums[i])
            }
        }
        val secondSmallest = maxHeap.poll()
        val smallest = maxHeap.poll()
        val thirdLargest = minHeap.poll()
        val secondLargest = minHeap.poll()
        val largest = minHeap.poll()

        return max(largest * secondLargest * thirdLargest, smallest * secondSmallest * largest)
    }

    @Test
    fun example1() {
        assertThat(
            maximumProduct(intArrayOf(1, 2, 3))
        ).isEqualTo(6)
    }

    @Test
    fun example2() {
        assertThat(
            maximumProduct(intArrayOf(1, 2, 3, 4))
        ).isEqualTo(24)
    }

    @Test
    fun example3() {
        assertThat(
            maximumProduct(intArrayOf(-1, -2, -3))
        ).isEqualTo(-6)
    }

    @Test
    fun exampleTwoNegatives() {
        assertThat(
            maximumProduct(intArrayOf(-100, -98, -1, 2, 3, 4))
        ).isEqualTo(39200)
    }
}