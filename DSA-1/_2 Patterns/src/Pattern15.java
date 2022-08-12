// https://nados.io/question/pattern-15

import java.util.Scanner;

public class Pattern15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sp = n/2;
        int k = 1;
        int st = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sp; j++)
                System.out.print("\t");

            int cval = k;
            for(int j=1; j<=st; j++) {
                System.out.print((cval) + "\t");

                if (j <= st / 2)
                    cval++;
                else
                    cval--;
            }

            if(i<=n/2) {
                sp -= 1;
                k++;
                st += 2;
            } else {
                sp += 1;
                k--;
                st -= 2;
            }

            System.out.println();
        }
    }
}
