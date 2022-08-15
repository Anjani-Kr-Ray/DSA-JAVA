// https://nados.io/question/spiral-display

import java.util.Scanner;

public class SpiralDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int rs=0, cs=0, ce=n-1, re=m-1, count=0;
        while(count < m*n) {
            for(int i=rs; i<=re && count < m*n; i++) {
                System.out.println(arr[i][cs]);
                count++;
            }
            cs++;

            for(int i=cs; i<=ce && count < m*n; i++) {
                System.out.println(arr[re][i]);
                count++;
            }
            re--;

            for(int i=re; i>=rs && count < m*n; i--) {
                System.out.println(arr[i][ce]);
                count++;
            }
            ce--;


            for(int i=ce; i>=cs && count < m*n; i--) {
                System.out.println(arr[rs][i]);
                count++;
            }
            rs++;

        }
    }
}