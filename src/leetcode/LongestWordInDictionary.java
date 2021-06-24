package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
public class LongestWordInDictionary {
    public String findLongestWord(String s, List<String> d) {
        if (s == null || s.isEmpty())
            return s;
        Collections.sort(d, Comparator.comparing(String::length).reversed().thenComparing(String::compareTo));
        int[] charFrequency = getWordFrequency(s);

        for (String str : d) {
            int[] currWordFreq = getWordFrequency(str);
            int i=0;
            for (; i<26; i++) {
                if (currWordFreq[i] > 0 && (currWordFreq[i] >  charFrequency[i])) {
                    break;
                }
            }
            if (i == 26)
                return str;
        }
        return "";
    }

    private int[] getWordFrequency(String str) {
        int[] charFrequency = new int[26];
        for (char ch : str.toCharArray()) {
            charFrequency[ch - 'a'] += 1;
        }
        return charFrequency;
    }

    public static void main(String[] args) {
        LongestWordInDictionary wordInDictionary = new LongestWordInDictionary();
        List<String> list = new ArrayList<>(List.of("ale","applf","apple","monkey","plea"));
        System.out.println(wordInDictionary.findLongestWord("abpcplea", list));

    }
}
