package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int max = 0;
        int right=0, left=0;
        Map<Character, Integer> currWindowCharCount = new HashMap<>();

        while (left <= right && right < s.length()) {

        }

        return max;
    }
}
