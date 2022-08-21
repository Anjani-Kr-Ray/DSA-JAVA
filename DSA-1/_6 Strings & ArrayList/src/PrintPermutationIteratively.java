// https://nados.io/question/print-all-permutations-of-a-string-iteratively

import java.util.Scanner;

public class PrintPermutationIteratively {

    public static int fact(int n) {
        if(n==1 || n==0)
            return 1;
        return n * fact(n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int n = str.length();
        int f = fact(n);

        for(int i=0; i<f; i++) {
            String res = "";
            StringBuilder strBuilder = new StringBuilder(str);
            int temp = i;
            for(int div=n; div>=1; div--) {
                int quotient = temp / div;
                int remainder = temp % div;
                res += strBuilder.charAt(remainder);
                strBuilder.deleteCharAt(remainder);
                temp = quotient;
            }
            System.out.println(res);
        }
    }
}
