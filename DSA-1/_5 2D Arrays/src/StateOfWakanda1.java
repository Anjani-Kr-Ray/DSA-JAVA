// https://nados.io/question/the-state-of-wakanda-1

import java.util.Scanner;

public class StateOfWakanda1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int i = -1, j = 0;
        while(j < n) {
            if(i<m) {
                i += 1;
                while(i<m) {
                    System.out.println(arr[i][j]);
                    i++;
                }
            } else {
                i -= 1;
                while(i>=0) {
                    System.out.println(arr[i][j]);
                    i--;
                }
            }
            j++;
        }
    }
}
