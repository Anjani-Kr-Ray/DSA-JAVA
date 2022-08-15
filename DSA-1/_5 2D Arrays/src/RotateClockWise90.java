// https://nados.io/question/rotate-by-90-degree

import java.util.Scanner;

public class RotateClockWise90 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // transpose
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i<j)
                    swap(matrix, i, j, j, i);
            }
        }

        // reverse
        for(int i=0; i<n; i++) {
            int sj=0, ej=n-1;
            while(sj<ej) {
                swap(matrix, i, sj, i, ej);
                sj++;
                ej--;
            }
        }

        // display matrix
        display(matrix);
    }

    public static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
