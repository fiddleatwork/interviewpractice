package coding.leetcode;

import kotlin.ranges.IntRange;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


/**
 * Source: https://leetcode.com/problems/defuse-the-bomb/description/?envType=daily-question&envId=2024-11-18
 */
public class Leet1652DefuseTheBombJavaTest {

    private int safeGet(int[] code, int i) {
        if(i >= 0) {
            return code[i % code.length];
        } else {
            return code[(code.length - Math.abs(i)) % code.length];
        }
    }

    public int[] decrypt(int[] code, int k) {
        return IntStream.range(0, code.length)
                .map(i -> {
                    // System.out.println("mapping " + i);
                    int sum = 0;
                    if (k > 0) {
                        for (int j = 0; j < k; j++) {
                            sum += safeGet(code, i + 1 + j);
                        }
                    } else {
                        for (int j = 0; j < (-1 * k); j++) {
                            sum += safeGet(code, i - 1 - j);
                        }
                    }
                    return sum;
                })
                .toArray();
    }

    @Test
    public void example1() {
        assertThat(
                decrypt(new int[]{5, 7, 1, 4}, 3)
        ).isEqualTo(new int[]{12, 10, 16, 13});
    }

    @Test
    public void example2() {
        assertThat(
                decrypt(new int[]{1, 2, 3, 4}, 0)
        ).isEqualTo(new int[]{0, 0, 0, 0});
    }

    @Test
    public void example3() {
        assertThat(
                decrypt(new int[]{2, 4, 9, 3}, -2)
        ).isEqualTo(new int[]{12, 5, 6, 13});
    }

}
