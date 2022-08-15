// https://nados.io/question/exit-point-of-a-matrix

import java.util.Scanner;

public class ExitPointOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[][] direction = {{0,1}, {1,0}, {0, -1}, {-1,0}};

        int i=0, j=0, direction_count = 0;

        while(i<m && j<n) {
            if(matrix[i][j] == 1) {
                direction_count = (direction_count + 1)%4;
            }

            i += direction[direction_count][0];
            j += direction[direction_count][1];
        }

        if(i==m) i-=1;
        if(j==n) j-=1;
        if(i==-1) i = 0;
        if(j==-1) j = 0;

        System.out.println(i+"\n"+j);
    }
}