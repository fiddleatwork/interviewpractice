package coding.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Leet003LongestSubstringWithoutRepeatingCharactersJavaTest {

    public int lengthOfLongestSubstring(String s) {

        if(s.isEmpty()) {
            return 0;
        }
        int max = 1;
        for(int start=0;start<s.length();start++) {
            for (int i=start+1; i< s.length();i++) {
                String substring = s.substring(start, i);
                if (substring.indexOf(s.charAt(i)) > -1) {
                    break;
                }
                max = Math.max(max, substring.length() + 1);
            }
        }
        return max;

    }

    @Test
    public void testExample1() {
        assertThat(lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
    }

    @Test
    public void testExample2() {
        assertThat(lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
    }

    @Test
    public void testExample3() {
        assertThat(lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }

}