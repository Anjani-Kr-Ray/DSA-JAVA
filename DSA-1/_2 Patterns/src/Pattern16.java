// https://nados.io/question/pattern-16

import java.util.Scanner;

public class Pattern16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sp = 2*n-3, st = 1;
        for(int i=1; i<=n; i++) {
            int k = 1;
            for(int j=1; j<=st; j++, k++)
                System.out.print(k+"\t");
            for(int j=1; j<=sp; j++)
                System.out.print("\t");
            if(i==n) {
                st--;
                k--;
            }
            for(int j=1; j<=st; j++) {
                k--;
                System.out.print(k + "\t");
            }
            sp -= 2;
            st++;
            System.out.println();
        }
    }
}
