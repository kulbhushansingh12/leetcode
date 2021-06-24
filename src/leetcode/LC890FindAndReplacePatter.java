package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/find-and-replace-pattern/
public class LC890FindAndReplacePatter {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();

        for (String word : words) {
            Map<Character, Character> wordMap = new HashMap<>();
            Map<Character, Character> patMap = new HashMap<>();
            boolean isValid = true;
            for (int i =0; i<word.length(); i++) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);
                if (!wordMap.containsKey(w)) {
                    wordMap.put(w, p);
                }
                if (!patMap.containsKey(p)) {
                    patMap.put(p, w);
                }

                if (wordMap.get(w) != p || patMap.get(p) != w) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                res.add(word);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC890FindAndReplacePatter findAndReplacePatter = new LC890FindAndReplacePatter();
        System.out.println(findAndReplacePatter.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb"));
    }
}
