import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class A {
    public String c;
    public B b;
}
class B {
    public String id;
    public String name;
    public C c;
}

class C {
    public String abc;
}

class Pair {
    public Field field;
    public Object object;

    public Pair(Field field, Object object) {
        this.field = field;
        this.object = object;
    }
}
public class Main {
    static int maxCurrentSum = 0;
    public static void main(String []args) throws NoSuchFieldException, IllegalAccessException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        priorityQueue.add(2);
        priorityQueue.add(1);
        priorityQueue.add(3);
        while (priorityQueue.size() > 0) {
            System.out.println(priorityQueue.remove());
        }
    }

    // good method don't delete. Dynamic traversal of object
    private static Pair resolveDataPath(String path, Object parent) throws NoSuchFieldException, IllegalAccessException {
        String subString = path;
        if (!subString.contains("."))
        {
            //We haven reached the end of the path
            return new Pair(parent.getClass().getDeclaredField(subString), parent);
        }
        //We haven't reached the end of the
        subString = path.substring(0, path.indexOf("."));
        Field field = parent.getClass().getDeclaredField(subString);
        Object val = field.get(parent);
        return resolveDataPath(path.substring(path.indexOf(".")+1), val);
    }



    private static int maxDifference(List<Integer> px) {
        int maxDiff = -1;

        for (int i=px.size()-1; i>0; i--) {
            for (int j= i-1; j>=0; j--) {
                maxDiff = Math.max(Math.max((px.get(i) - px.get(j)), maxDiff), -1);
            }
        }

        return maxDiff;
    }

    public int[][] diagonal(int[][] A) {
        if (A.length == 0) {
            return new int[][]{{}};
        }
        List<List<Integer>> resultList = new ArrayList<>();
        boolean[][] visited = new boolean[A.length][A[0].length];

        for (int row=0; row<A.length; row++) {
            for (int col=0; col<A[row].length; col++) {
                if (!visited[row][col]) {
                    List<Integer> currElementList = new ArrayList<>();
                    visitDiagonally(A, row, col, currElementList, visited);
                    resultList.add(currElementList);
                }
            }

        }

        int[][] res = new int[resultList.size()][];

        for (int i=0; i<resultList.size(); i++) {

            List<Integer> resultRow = resultList.get(i);
            int[] currRow = new int[resultRow.size()];
            for (int j=0; j<resultRow.size(); j++) {
                currRow[j] = resultRow.get(j);
            }
            res[i] = currRow;
        }
        return res;
    }

    private void visitDiagonally(int[][] A, int row, int col, List<Integer> elementList, boolean[][] visited) {
        if (isValid(row, col, visited, A.length, A[0].length)) {
            visited[row][col] = true;
            elementList.add(A[row][col]);
            visitDiagonally(A, row+1, col-1, elementList, visited);
        }
    }

    private boolean isValid(int row, int col, boolean[][] visited, int rowLimit, int colLimit) {
        return row >= 0 && row < rowLimit && col >= 0 && col < colLimit && !visited[row][col];
    }

    private static void dfs(List<Integer> weights, int index, List<Integer> current, int currentSum, int maxCapacity){
        if (currentSum > maxCurrentSum && currentSum <= maxCapacity) {
            maxCurrentSum = currentSum;
        }
        int len = weights.size();
        for(int i= index; i<len; i++){
            current.add(weights.get(i));
            currentSum += weights.get(i);
            dfs(weights,i+1,current, currentSum, maxCapacity);
            currentSum -= current.get(current.size() - 1);
            current.remove(current.size()-1);
        }
    }

    public static int weightCapacity(List<Integer> weights, int maxCapacity) {
        int curr_sum = weights.get(0), max_sum = 0, start = 0;
        // To find max_sum less than sum
        for (int i = 1; i < weights.size(); i++) {
            // Update max_sum if it becomes
            // greater than curr_sum
            if (curr_sum <= maxCapacity)
                max_sum = Math.max(max_sum, curr_sum);
            // If curr_sum becomes greater than
            // sum subtract starting elements of array
            while (curr_sum + weights.get(i) > maxCapacity && start < i) {
                curr_sum -= weights.get(start);
                start++;
            }
            // Add elements to curr_sum
            curr_sum += weights.get(i);
        }
        // Adding an extra check for last subarray
        if (curr_sum <= maxCapacity)
            max_sum = Math.max(max_sum, curr_sum);
        return max_sum;
    }

    public static void rotateArray(int k, int[] arr) {
        k %= arr.length;
        int n = arr.length - 1;
        while(n > 0) {

        }
    }

    public static int convert(int num) {
        char[] arr = String.valueOf(num).toCharArray();
        String result="";
        boolean isNeg=num<0?true:false;
        int i=0;
        int len=arr.length;
        if(isNeg){
            i=1;
        }
        for(;i<len;i++){
            if(!isNeg && arr[i]-'0'<5){
                result="5"+result+new String(arr, i, len-i);
                return Integer.valueOf(result);
            }else if(!isNeg && arr[i]-'0'<5){
                result=result+ "5" + new String(arr, i, len-i);
                return Integer.valueOf(result);
            }
            result += arr[i];
        }
        return isNeg?Integer.valueOf(result + "5"):-1*Integer.valueOf("5" + result);
    }

    static int matchingRegions = 0;
    static boolean isValidGrid = true;
    static boolean isGrid1Valid = true;
    static boolean isGrid2Valid = true;
    public static int countMatches(List<String> grid1, List<String> grid2) {
        // Write your code here
        if (grid1 == null || grid1.size() == 0 || grid2 == null || grid2.size() == 0)
            return 0;
        boolean[][] visited = new boolean[grid1.size()][grid1.get(0).length()];
        for (int row=0; row < grid1.size(); row ++) {
            for (int col=0; col < grid1.get(row).length(); col++) {
                char currChar1 = grid1.get(row).charAt(col);
                char currChar2 = grid2.get(row).charAt(col);

                if (!visited[row][col]) {
                    visited[row][col] = true;
                    // if one of them is 1 visit and mark them visited for both
                    if (currChar1 == '1' || currChar2 == '1') {
                        isValidGrid = (currChar1 == currChar2);
                        isGrid1Valid = currChar1 == '1';
                        isGrid2Valid = currChar2 == '1';
                        explorePossibleOnes(grid1, grid2, row, col, visited, isGrid1Valid, isGrid2Valid);
                        if (isValidGrid) {
                            ++matchingRegions;
                        }
                    }
                }
            }
        }
        int result = matchingRegions;
        matchingRegions = 0;
        isValidGrid  =true;
        isGrid1Valid = true;
        isGrid2Valid= true;
        return result;
    }

    private static void explorePossibleOnes(List<String> grid1, List<String> grid2, int row, int col, boolean[][] visited,
                                            boolean isGrid1Valid, boolean isGrid2Valid) {
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};

        for (int i=0; i<4; i++) {
            int currRow = row + dirX[i];
            int currCol = col + dirY[i];
           if (isValid(currRow, currCol, grid1.size(), grid1.get(0).length(), visited)) {
               //if one of them is valid we will continue but not count
               char currChar1 = grid1.get(currRow).charAt(currCol);
               char currChar2 = grid2.get(currRow).charAt(currCol);
               visited[row][col] = true;
               if (currChar1 == '1' || currChar2 == '1') {
                   if (currChar1 != currChar2) {
                       isValidGrid = false;
                   }
                   if ((isGrid1Valid && currChar1 != '1') || (isGrid2Valid && currChar2 != '1'))
                       return;

                   if (currChar1 != '1')
                       isGrid1Valid = false;

                   if (currChar2 != '1')
                       isGrid2Valid = false;
                   explorePossibleOnes(grid1, grid2, currRow, currCol, visited, isGrid1Valid, isGrid2Valid);
               }
           }
        }
    }

    private static boolean isValid(int row, int col, int rowLimit, int colLimit, boolean[][] visited) {
        return row >= 0 && col >= 0 && row < rowLimit && col < colLimit && !visited[row][col];
    }


}
