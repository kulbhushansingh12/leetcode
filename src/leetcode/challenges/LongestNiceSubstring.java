package leetcode.challenges;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/contest/biweekly-contest-46/problems/longest-nice-substring/
public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        int largestLength = 0;
        String result = "";
        for (int i=0; i<s.length(); i++) {
            Map<Character, Character> expectedChar = new HashMap<>();
            for (int j = i+1; j<s.length(); j++) {
                String str = s.substring(i, j+1);
                if (isValid(str) && str.length() > largestLength) {
                    largestLength = str.length();
                    result = str;
                }
            }
        }

        return result;
    }

    private boolean isValid(String str) {
        Map<Character, Integer> counterChar = new HashMap<>();
        for (char ch : str.toCharArray()) {
            counterChar.put(ch, 0);
            if (Character.isLowerCase(ch) && counterChar.get((char)(ch - 32)) == null) {
                counterChar.put((char) (ch - 32), -1);
            } else if (Character.isUpperCase(ch) && counterChar.get((char)(ch + 32)) == null) {
                counterChar.put((char) (ch + 32), -1);
            }
        }

        for (int num : counterChar.values()) {
            if (num == -1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        LongestNiceSubstring niceSubstring = new LongestNiceSubstring();
        System.out.println(niceSubstring.longestNiceSubstring("YazaAay"));
        System.out.println(niceSubstring.longestNiceSubstring("Bb"));
        System.out.println(niceSubstring.longestNiceSubstring("c"));
        System.out.println(niceSubstring.longestNiceSubstring("dDzeE"));
    }
}
