package geeksforgeeks.Stack;

import java.util.Stack;

// https://leetcode.com/problems/simplify-path/
public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] strArr = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String str : strArr) {
            if (str.equals(".")) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.isEmpty()){
                stack.push(str);
            }
        }

        String[] resultArray = new String[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            resultArray[resultArray.length - 1 - index] = stack.pop();
            ++index;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<resultArray.length;i++) {
            stringBuilder.append("/")
                    .append(resultArray[i]);
        }

        return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home//foo/"));
        System.out.println(simplifyPath.simplifyPath("/../"));
        System.out.println(simplifyPath.simplifyPath("/home/"));
        System.out.println(simplifyPath.simplifyPath("/a/./b/../../c/"));
    }
}
