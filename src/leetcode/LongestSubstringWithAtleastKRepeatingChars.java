package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringWithAtleastKRepeatingChars {
    int max = 0;
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }

        int[] currentStrFrequency = getCharFreq(s);

        // current window hold frequency of chars with less than k
        Map<Character, Integer> charCounter = new HashMap<>();//chars with less than k elements
        int startWindow = 0;
        int[] charCounterWithGreaterThanK = new int[26];
        int i=0;
        for (; i<s.length(); i++) {
            char currChar = s.charAt(i);
            if (currentStrFrequency[currChar - 'a'] < k) {
                int charCounterSize = charCounter.size();
                if (charCounterSize == 0 && ( (i-1) < 0 || currentStrFrequency[s.charAt(i-1) - 'a'] >= k)) {
                    //int currentSize = startWindow ==0 ? i -startWindow +1 : i-startWindow;
                    max = Math.max(max, i - startWindow);
                }
                charCounter.clear();
                startWindow = i + 1;
                charCounterWithGreaterThanK = new int[26];
                if ((i - 0) > k && currentStrFrequency[s.charAt(i-1) - 'a'] >= k && charCounterSize != 0) {
                    longestSubstring(s.substring(0, i), k);
                }
                if (s.length() - i > k) {
                    longestSubstring(s.substring(i+1), k);
                }
                i=s.length();
            } else {
                if (charCounterWithGreaterThanK[currChar - 'a'] > 0) {
                    ++charCounterWithGreaterThanK[currChar - 'a'];
                } else {
                    charCounter.put(currChar, charCounter.getOrDefault(currChar, 0) + 1);
                    if (charCounter.get(currChar) != null && charCounter.get(currChar) == k) {
                        charCounterWithGreaterThanK[currChar - 'a'] = charCounter.get(currChar);
                        charCounter.remove(currChar);
                    }
                }
            }

        }

        if (i == s.length() && charCounter.size() == 0) {
            max = Math.max(max, s.length() - startWindow);
        }

        return max;
    }

    private int[] getCharFreq(String s) {
        int[] charFreq = new int[26];
        for (char ch : s.toCharArray()) {
            charFreq[ch - 'a'] = charFreq[ch - 'a'] + 1;
        }
        return charFreq;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtleastKRepeatingChars kRepeatingChars = new LongestSubstringWithAtleastKRepeatingChars();
        System.out.println(kRepeatingChars.longestSubstring("aaaaa", 2));// 5
        kRepeatingChars = new LongestSubstringWithAtleastKRepeatingChars();
        System.out.println(kRepeatingChars.longestSubstring("aaacabaaaaa", 2));// 5
        kRepeatingChars = new LongestSubstringWithAtleastKRepeatingChars();
        System.out.println(kRepeatingChars.longestSubstring("aaabbbc", 2));// 6
        kRepeatingChars = new LongestSubstringWithAtleastKRepeatingChars();
        System.out.println(kRepeatingChars.longestSubstring("aaabbbc", 3));//6
        kRepeatingChars = new LongestSubstringWithAtleastKRepeatingChars();
        System.out.println(kRepeatingChars.longestSubstring("aabaaa", 3));//3
        kRepeatingChars = new LongestSubstringWithAtleastKRepeatingChars();
        System.out.println(kRepeatingChars.longestSubstring("aabaabbcaaa", 3));//7
        kRepeatingChars = new LongestSubstringWithAtleastKRepeatingChars();
        System.out.println(kRepeatingChars.longestSubstring("abaaaccbb", 3));//3
        kRepeatingChars = new LongestSubstringWithAtleastKRepeatingChars();
        System.out.println(kRepeatingChars.longestSubstring("baaabcb", 3));//3
        kRepeatingChars = new LongestSubstringWithAtleastKRepeatingChars();
        System.out.println(kRepeatingChars.longestSubstring("aaabbbcdefcdefgggggggggggggggcde", 3));//15
    }
}
