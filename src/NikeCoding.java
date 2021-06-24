import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class NikeCoding {
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid. An input string is valid if:a.
    // Open brackets must be closed by the same type of brackets.b.
    // Open brackets must be closed in the correct order.Example:Input: s = "()"Output: trueInput: s = "{(){}()}"Output: true
    // Input: s = "({[})"Output: false


    // Say you have an array for which each element is the price of a given stock on day.
    // If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
    // design an algorithm to find the maximum profit.Note that you cannot sell a stock before you buy one.
    // Example:Input: [7,1,5,3,6,4] Output: 5


    // A palindrome is a word, phrase or sequence of characters that reads the same backwards and forwards.
    // Write a function that would identify if a string is a palindrome.ExampleInput: abcbaOutput: true

    // Write a method that shuffles a deck of cards. It must be a perfect shuffle –in other words, each of the 52!
    // permutations of the deck has to be equally likely. Assume you are given a random number generator which is perfect


    public boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        for (int i=0; i<str.length()/2 ; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean validateString(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        //'(', ')', '{', '}', '[' and ']'
        // ((({}
        // --> (((
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put('}', '{');
        charMap.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty() && stack.peek() !=  charMap.get(ch)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public String[] shuffleCard(String[] strArr) {
        if (strArr == null || strArr.length < 2) {
            return strArr;
        }
        Random random = new Random();
        for (int i=0; i<strArr.length;i++) {
            int index = random.nextInt(52);
            String temp = strArr[index];
            strArr[i] = temp;
            strArr[index] = strArr[i];
        }
        return strArr;
    }


    // Say you have an array for which each element is the price of a given stock on day.
    // If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
    // design an algorithm to find the maximum profit.Note that you cannot sell a stock before you buy one.
    // Example:Input: [7,1,5,3,6,4] Output: 5
    // 7

    public int maxProfit(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : arr) {
            if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }

            if (price < minPrice) {
                minPrice = price;
            }
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        NikeCoding nikeCoding = new NikeCoding();
        System.out.println(nikeCoding.maxProfit(new int[]{7,1,5,3,6,4}));
    }

}
