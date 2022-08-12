// https://nados.io/question/pattern-inverted-hour-glass

import java.util.Scanner;

public class Pattern22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sp = 0, st = n;

        for(int i=1; i<=n; i++) {

            for(int j=1; j<=sp; j++)
                System.out.print("\t");

            for(int j=1; j<=st; j++)
                if(i<=n/2 || i==n || (i>n/2 && (j==1 || j==st)))
                    System.out.print("*\t");
                else
                    System.out.print("\t");

            if(i<=n/2) {
                sp++;
                st-=2;
            } else {
                sp--;
                st+=2;
            }
            System.out.println();
        }
    }
}
