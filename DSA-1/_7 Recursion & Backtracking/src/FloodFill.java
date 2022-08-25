// https://nados.io/question/flood-fill

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] maze = new int[row][col];

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        boolean[][] visited = new boolean[row][col];
        printPath(maze, 0,0, "", visited);
    }

    public static void printPath(int[][] maze, int row, int col, String res, boolean[][] visited) {
        if(row < 0 || col < 0 || row == maze.length || col == maze[0].length || maze[row][col] == 1 || visited[row][col]) {
            return;
        }
        if(row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(res);
            return;
        }

        visited[row][col] = true;
        printPath(maze, row-1, col, res+"t", visited);
        printPath(maze, row, col-1, res+"l", visited);
        printPath(maze, row+1, col, res+"d", visited);
        printPath(maze, row, col+1, res+"r", visited);
        visited[row][col] = false;
    }
}
