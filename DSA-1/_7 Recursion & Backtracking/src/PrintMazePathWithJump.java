// https://nados.io/question/print-maze-paths-with-jumps

import java.util.Scanner;

public class PrintMazePathWithJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dr = sc.nextInt();
        int dc = sc.nextInt();
        printMaze(1,1, dr, dc, "");
    }

    public static void printMaze(int sr, int sc, int dr, int dc, String res) {
        if(sr==dr && sc==dc) {
            System.out.println(res);
            return;
        }

        for(int i=1; i<=dc-sc; i++) {
            printMaze(sr, sc+i, dr, dc, res+"h"+i);
        }

        for(int i=1; i<=dr-sr; i++) {
            printMaze(sr+i, sc, dr, dc, res+"v"+i);
        }

        for(int i=1; i<=dc-sc && i<=dr-sr; i++) {
            printMaze(sr+i, sc+i, dr, dc, res+"d"+i);
        }
    }
}
