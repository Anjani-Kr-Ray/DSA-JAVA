// https://nados.io/question/print-stair-paths

import java.util.Scanner;

public class PrintStairPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPath(n, "");
    }

    public static void printPath(int n, String res) {
        if(n==0) {
            System.out.println(res);
            return;
        }
        if(n<0) {
            return;
        }
        printPath(n-1, res+"1");
        printPath(n-2, res+"2");
        printPath(n-3, res+"3");
    }
}
