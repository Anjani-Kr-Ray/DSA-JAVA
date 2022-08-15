// https://nados.io/question/matrix-multiplication

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int n1 = sc.nextInt();

        int[][] matrix1 = new int[m1][n1];
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        int m2 = sc.nextInt();
        int n2 = sc.nextInt();

        int[][] matrix2 = new int[m2][n2];
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        if(n1!=m2) {
            System.out.println("Invalid input");
            return;
        }

        int[][] res = new int[m1][n2];

        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n2; j++) {
                int sum = 0;
                for (int k = 0; k < n1; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                res[i][j] = sum;
            }
        }

        for (int[] arr: res) {
            for (int num : arr) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}