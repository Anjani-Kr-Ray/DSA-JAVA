// https://nados.io/question/is-a-number-prime

import java.util.Scanner;

public class CheckIfPrime {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for(int i=0; i<n; i++) {
            int m = Integer.parseInt(sc.nextLine());
            int count = 0;

            // n^2 --> TLE
            /*
            for(int j=2; j<=m; j++) {
                if(m%j == 0) {
                    count += 1;
                }
            }
            */

            // n*(n^(1/2))
            for(int j=2; j*j <= m; j++) {
                if(m % j == 0) {
                    count += 1;
                    break;
                }
            }

            if(count >= 1)
                System.out.println("not prime");
            else
                System.out.println("prime");
        }

    }
}
