package coding.educative.patterns.topk;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class KthSmallestNumberJava {

    static Integer kthSmallestNumber(List<Integer> numbers, Integer k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        maxHeap.addAll(numbers.subList(0, k));

        numbers.subList(k, numbers.size())
                .forEach(n -> {
                    if (n < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.add(n);
                    }
                });

        return maxHeap.peek();
    }

    @Test
    void example() {
        List<Integer> numbers = List.of(1, 5, 12, 2, 11, 5);
        assertThat(kthSmallestNumber(numbers, 3)).isEqualTo(5);
    }

}


