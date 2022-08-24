// https://nados.io/question/print-maze-paths

import java.util.Scanner;

public class PrintMazePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dr = sc.nextInt();
        int dc = sc.nextInt();
        printMazePath(1,1,dr, dc, "");

    }
    public static void printMazePath(int sr, int sc, int dr, int dc, String res) {
        if(sr==dr && sc==dc) {
            System.out.println(res);
            return;
        }
        if(sr>dr || sc>dc)
            return;

        printMazePath(sr, sc+1, dr, dc, res+"h");
        printMazePath(sr+1, sc, dr, dc, res+"v");
    }
}
