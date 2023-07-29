package matrix;

// Java implementation to sort the given matrix
import java.util.*;

 public class Sort {

    // function to sort the given matrix
    static void sortMat(int[][] mat, int rows, int cols) {
        // temporary array of size rows * cols
        int[] temp = new int[rows * cols];
        int k = 0;

        // copy the elements of matrix one by one into temp[]
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                temp[k++] = mat[i][j];
            }
        }

        // sort temp[]
        Arrays.sort(temp);

        // copy the elements of temp[] back into mat[][]
        k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = temp[k++];
            }
        }
    }

    // function to print the given matrix
    static void printMat(int[][] mat, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = { { 5, 4, 7 }, { 1, 3, 8 }, { 2, 9, 6 }, { 10, 12, 11 } };
        int rows = 4;
        int cols = 3;

        System.out.println("Original Matrix:");
        printMat(mat, rows, cols);

        sortMat(mat, rows, cols);

        System.out.println("\nMatrix After Sorting:");
        printMat(mat, rows, cols);
    }
}
