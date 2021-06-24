package leetcode.challenges;

public class MergeStringAlternately {
    public String mergeAlternately(String word1, String word2) {
        if (word2 == null || word2.isEmpty()) return word1;
        if (word1 == null || word1.isEmpty()) return word1;
        int word2Length = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<word1.length(); i++) {
            sb.append(word1.charAt(i));
            if (word2Length < word2.length()) {
                sb.append(word2.charAt(word2Length));
                ++word2Length;
            }
        }

        if (word2Length < (word2.length())) {
            sb.append(word2.substring(word2Length));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MergeStringAlternately stringAlternately = new MergeStringAlternately();
        System.out.println(stringAlternately.mergeAlternately("cf", "eee"));
        System.out.println(stringAlternately.mergeAlternately("ab", "pqrs"));
        System.out.println(stringAlternately.mergeAlternately("abcd", "pqrs"));
        System.out.println(stringAlternately.mergeAlternately("abcd", "pq"));
    }
}
