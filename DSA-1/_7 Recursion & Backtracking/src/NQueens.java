// https://nados.io/question/n-queens

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        printNQueen(matrix, "", 0);
    }

    public static void printNQueen(int[][] matrix, String res, int row) {
        if(row == matrix.length) {
            System.out.println(res+".");
            return;
        }
        for(int col=0; col<matrix.length; col++) {
            if(isSafe(matrix, row, col)) {
                matrix[row][col] = 1;
                printNQueen(matrix, res + row + "-" + col + ", ", row + 1);
                matrix[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] matrix, int row, int col) {
        for(int i=row-1, j=col; i>=0; i--) {
            if(matrix[i][j] == 1)
                return false;
        }

        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if(matrix[i][j] == 1)
                return false;
        }

        for(int i=row-1, j=col+1; i>=0 && j<matrix.length; i--, j++) {
            if(matrix[i][j] == 1)
                return false;
        }

        return true;
    }
}
