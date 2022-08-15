import java.util.Scanner;

public class SearchInSorted2dMatrix {
    public static int[] searchByReducingSpace(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int start = 0, end = col - 1;

        while(start < row && end >= 0) {
            if(matrix[start][end] == target)
                return new int[] {start, end};
            else if(matrix[start][end] > target)
                end--;
            else
                start++;
        }

        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int target = sc.nextInt();
        int[] index = searchByReducingSpace(matrix, target);
        if(index[0] != -1 && index[1] != -1) {
            System.out.println(index[0]+"\n"+index[1]);
        } else {
            System.out.println("Not Found");
        }
    }
}
