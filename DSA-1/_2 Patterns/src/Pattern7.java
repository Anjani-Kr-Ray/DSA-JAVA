// https://nados.io/question/pattern-7

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i-1; j++) {
                System.out.print("\t");
            }
            System.out.print("*");
            System.out.println();
        }
    }
}
