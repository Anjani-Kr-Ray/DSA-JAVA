// https://nados.io/question/pattern-13

import java.util.Scanner;

public class Pattern13 {
    public static int fact(int n) {
        if( n <= 1)
            return 1;
        return n * fact(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // Method 1: It uses simple nCk formula i.e., n! / (k! * (n-k)!)
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=i; j++) {
                int icj = fact(i) / (fact(j) * fact(i - j));
                System.out.print(icj+"\t");
            }
            System.out.println();
        }


        // Method 2: It uses formula nC(k+1) = (nCk * (n-k)) / (k+1)
        for(int i=0; i<=n; i++) {
            int icj = 1;
            for(int j=0; j<=i; j++) {
                System.out.print(icj+"\t");
                icj = (icj * (i - j)) / (j+1);
            }
            System.out.println();
        }
    }
}
