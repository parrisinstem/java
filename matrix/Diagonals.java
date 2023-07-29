package matrix;

// Java Program to print the Diagonals of a Matrix
public class Diagonals {

    // Function to print the Principal Diagonal
    public static void printPrincipalDiagonal(int mat[][], int n) {
        System.out.print("Principal Diagonal: ");
        for (int i = 0; i < n; i++) {
            System.out.print(mat[i][i] + ", ");
        }
        System.out.print("\n");
    }

    // Function to print the Secondary Diagonal
    public static void printSecondaryDiagonal(int mat[][], int n) {
        System.out.print("Secondary Diagonal: ");
        for (int i = 0; i < n; i++) {
            System.out.print(mat[i][n - 1 - i] + ", ");
        }
        System.out.print("\n");
    }

    // Driver Code
    public static void main(String[] args) {
        int n = 4;
        int a[][] = { { 1, 2, 3, 4 },
                      { 5, 6, 7, 8 },
                      { 1, 2, 3, 4 },
                      { 5, 6, 7, 8 } };

        printPrincipalDiagonal(a, n);
        printSecondaryDiagonal(a, n);
    }
}
