package leetcode.matrix;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/valid-sudoku/
public class ValidateSudoku {
    public boolean isValidSudoku(char[][] board) {
        // cache of every row with all digit seen
        Map<Integer, boolean[]> rowCache = new HashMap<>();
        // cache of every col with all digit seen
        Map<Integer, boolean[]> colCache = new HashMap<>();
        // cache of every sub-matrix
        // divide the matrix in 3*3 row/3 and col/3
        Map<Integer, Map<Integer, boolean[]>> subMatrixCache = new HashMap<>();

        for (int row=0; row<board.length;row++) {
            for (int col=0; col<board[row].length; col++) {
                // validate row
                boolean[] current = rowCache.getOrDefault(row, new boolean[10]);
                // The current condition checks if the digit is already found
                if (board[row][col] - '0' > 0 && current[board[row][col] - '0']) {
                    return false;
                } else if (board[row][col] - '0' > 0){
                    // If it is not found in current row, update the row with the updated bool array
                    current[board[row][col] - '0'] = true;
                    rowCache.put(row, current);
                }

                // For column we are validating one column in one pass
                boolean[] currentCol = colCache.getOrDefault(row, new boolean[10]);
                if (board[col][row] - '0' > 0 && currentCol[board[col][row] - '0']) {
                    return false;
                } else if (board[col][row] - '0' > 0) {
                    currentCol[board[col][row] - '0'] = true;
                    colCache.put(row, currentCol);
                }

                // Validate sub-matrix
                Map<Integer, boolean[]> colMatrixCache = subMatrixCache.getOrDefault(row/3, new HashMap<>());
                boolean[] currentSubMatrix = colMatrixCache.getOrDefault(col/3, new boolean[10]);
                if (board[row][col] - '0' > 0 && currentSubMatrix[board[row][col] - '0']) {
                    return false;
                } else if (board[row][col] - '0' > 0) {
                    currentSubMatrix[board[row][col] - '0'] = true;
                    colMatrixCache.put(col/3, currentSubMatrix);
                    subMatrixCache.put(row/3, colMatrixCache);
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateSudoku validateSudoku = new ValidateSudoku();
        System.out.println(validateSudoku.isValidSudoku(new char[][]{
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}}));
    }
}
