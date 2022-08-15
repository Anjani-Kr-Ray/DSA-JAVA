// https://nados.io/question/saddle-price

import java.util.Scanner;

public class SaddlePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        boolean flag = false;
        int saddle = 0;
        for(int i=0; i<n; i++) {
            int min = arr[i][0], col = 0;
            for(int j=1; j<n; j++) {
                if(arr[i][j] < min) {
                    min = arr[i][j];
                    col = j;
                }
            }
            int max = arr[0][col];
            for(int k=1; k<n; k++) {
                if(arr[k][col] > max) {
                    max = arr[k][col];
                }
            }

            if(min == max) {
                flag = true;
                saddle = max;
                break;
            }
        }

        if(flag)
            System.out.println(saddle);
        else
            System.out.println("Invalid input");

    }
}
