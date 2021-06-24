package leetcode;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/
public class LC150RPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> vals = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "/":
                    int val2 = vals.pop();
                    int val1 = vals.pop();
                    vals.push(val1/val2);
                    break;
                case "*":
                    val2 = vals.pop();
                    val1 = vals.pop();
                    vals.push(val1 * val2);
                    break;
                case "+":
                    val2 = vals.pop();
                    val1 = vals.pop();
                    vals.push(val1 + val2);
                    break;
                case "-":
                    val2 = vals.pop();
                    val1 = vals.pop();
                    vals.push(val1 - val2);
                    break;
                default:
                    vals.push(Integer.valueOf(token));
                    break;
            }
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        LC150RPN rpn = new LC150RPN();
        System.out.println(rpn.evalRPN(new String[]{"2","1","+","3","*"}));//9
        System.out.println(rpn.evalRPN(new String[]{"4","13","5","/","+"}));//6
        System.out.println(rpn.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));//22
    }
}
