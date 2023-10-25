package coding.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Leet2908MinimumSumOfMountainTripletsJava {

    // 8,6,1,5,3
    //     ^ ^ ^

    // 5,4,8,7,10,2
    //   ^ ^      ^
    public static int minimumSum(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        for (int i=0;i<nums.length-2;i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    if(nums[i] < nums[j] && nums[k] < nums[j]) {
                        if(nums[i] + nums[j] + nums[k] < minSum) {
                            minSum = nums[i] + nums[j] + nums[k];
                        }
                    }
                }
            }
        }
        if(minSum < Integer.MAX_VALUE) {
            return minSum;
        } else {
            return -1;
        }
    }


    @Test
    public void example1() {
        assertThat(minimumSum(new int[]{8,6,1,5,3})).isEqualTo(9);
    }

    @Test
    public void example2() {
        assertThat(minimumSum(new int[]{5,4,8,7,10,2})).isEqualTo(13);
    }

    @Test
    public void example3() {
        assertThat(minimumSum(new int[]{6,5,4,3,4,5})).isEqualTo(-1);
    }

}