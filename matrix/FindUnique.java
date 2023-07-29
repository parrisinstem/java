package matrix;


public class FindUnique {

    // function that calculates unique elements
    static void unique(int[][] mat, int n, int m) {
        int maximum = 0;
        boolean foundUnique = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Find maximum element in the matrix
                if (maximum < mat[i][j]) {
                    maximum = mat[i][j];
                }
            }
        }

        // Take 1-D array of (maximum + 1) size
        int[] b = new int[maximum + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int y = mat[i][j];
                b[y]++;
            }
        }

        // print unique elements
        for (int i = 1; i <= maximum; i++) {
            if (b[i] == 1) {
                System.out.print(i + " ");
                foundUnique = true;
            }
        }

        if (!foundUnique) {
            System.out.print("No unique element in the matrix");
        }
    }

    public static void main(String[] args) {
        int R = 4, C = 4;
        int[][] mat = { { 1, 2, 3, 20 },
                        { 5, 6, 20, 25 },
                        { 1, 3, 5, 6 },
                        { 6, 7, 8, 15 } };

        // function that calculates unique elements
        unique(mat, R, C);
    }
}

