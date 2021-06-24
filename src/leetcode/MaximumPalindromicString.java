package leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumPalindromicString {
    public int longestPalindrome(String word1, String word2) {
        int maxLength = Integer.MIN_VALUE;
        // Check if there is any common character
        Set<Character> characterSet = new HashSet<>();
        for (char ch : word1.toCharArray()) {
            characterSet.add(ch);
        }
        int index = 0;
        for (; index<word2.length(); index++) {
            if (characterSet.contains(word2.charAt(index)))
                break;
        }
        if (index == word2.length()) {
            return 0;
        }

        for (int i=0; i< word1.length(); i++) {
            for (int j=0; j<word2.length(); j++) {
                String str = word1.substring(0, i+1) + word2.substring(0, j+1);
                maxLength = Math.max(lps(str), maxLength);
            }
        }

        return maxLength;
    }

    private int lps(String seq)
    {
        int n = seq.length();
        int i, j, cl;
        int L[][] = new int[n][n];

        for (i = 0; i < n; i++)
            L[i][i] = 1;

        for (cl=2; cl<=n; cl++)
        {
            for (i=0; i<n-cl+1; i++)
            {
                j = i+cl-1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (seq.charAt(i) == seq.charAt(j))
                    L[i][j] = L[i+1][j-1] + 2;
                else
                    L[i][j] = Math.max(L[i][j-1], L[i+1][j]);
            }
        }

        return L[0][n-1];
    }

    public static void main(String[] args) {
        MaximumPalindromicString palindromicString = new MaximumPalindromicString();
        System.out.println(palindromicString.longestPalindrome("cacb", "cbba"));
        System.out.println(palindromicString.longestPalindrome("ab", "ab"));
        System.out.println(palindromicString.longestPalindrome("aa", "bb"));


    }
}
