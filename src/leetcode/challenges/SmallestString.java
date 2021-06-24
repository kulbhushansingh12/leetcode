package leetcode.challenges;

// https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
public class SmallestString {
    // 3, 27
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int index = n; index > 0; index--) {
            int maxPossibleValue = k - index + 1;
            if (maxPossibleValue  > 0 && maxPossibleValue <=26)  {
                sb.append((char)(k - index + 1 + 96));
                k -= (k - index + 1);
            } else if (k > 26) {
                sb.append('z');
                k -= 26;
            } else {
                sb.append('a');
                k = k-1;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        SmallestString ss = new SmallestString();
        System.out.println(ss.getSmallestString(3, 27));
        System.out.println(ss.getSmallestString(5, 73));
    }
}
