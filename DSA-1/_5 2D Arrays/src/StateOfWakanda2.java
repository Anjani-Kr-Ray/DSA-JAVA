// https://nados.io/question/the-state-of-wakanda-2

import java.util.Scanner;

public class StateOfWakanda2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int g = 0; g < arr.length; g++) {
            for (int i = 0, j = g; j < arr[0].length; i++, j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}
