package coding.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class Leet2899LastVisitedIntegersJava {

    public static List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        int index = -1;
        for (String word : words) {
            if (word.equals("prev")) {
                if (index < 0) {
                    result.add(-1);
                } else {
                    result.add(numbers.get(index));
                    index--;
                }
            } else {
                numbers.add(Integer.valueOf(word));
                index = numbers.size()-1;
            }
        }

        return result;
    }

    @Test
    public void example1() {
        assertThat(
                lastVisitedIntegers(List.of("1","2","prev","prev","prev"))
        ).isEqualTo(List.of(2, 1, -1));
    }

    @Test
    public void example2() {
        assertThat(
                lastVisitedIntegers(List.of("1","prev","2","prev","prev"))
        ).isEqualTo(List.of(1,2,1));
    }

}