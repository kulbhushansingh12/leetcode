package leetcode;

//https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        return String.valueOf(convertStringToInteger(num1) * convertStringToInteger(num2));
    }

    public int convertStringToInteger(String num) {
        int numInt = 0;
        int powCount = num.length() - 1;
        for (char ch : num.toCharArray()) {
            numInt += (int)Math.pow(10, powCount) * (ch - 48);
            --powCount;
        }
        return numInt;
    }

    public static void main(String[] args) {
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("2", "3"));
        System.out.println(multiplyStrings.multiply("123", "456"));
        //System.out.println(multiplyStrings.convertStringToInteger("2"));
    }
}
