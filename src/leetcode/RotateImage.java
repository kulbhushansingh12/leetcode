package leetcode;

//https://leetcode.com/problems/rotate-image/
public class RotateImage {
    public void rotate(int[][] matrix) {
        for (int row = 0; row < (matrix.length + 1) / 2; row++) {
            for (int col = 0; col < matrix.length/2; col++) {
                int temp = matrix[matrix.length - 1 - col][row]; // Last row element
                matrix[matrix.length - 1 - col][row] = matrix[matrix.length - 1 - row][matrix.length - 1 - col]; // Corner most element
                matrix[matrix.length - 1 - row][matrix.length - 1 - col] = matrix[col][matrix.length - 1 - row]; // right side col
                matrix[col][matrix.length - 1 - row] = matrix[row][col]; //
                matrix[row][col] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(new int[][] {{1,2,3}, {4,5,6}, {7,8,9}});
    }
}
