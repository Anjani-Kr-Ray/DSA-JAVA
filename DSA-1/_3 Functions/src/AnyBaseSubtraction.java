// https://nados.io/question/any-base-subtraction

import java.util.Scanner;

public class AnyBaseSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int d = getSubtraction(b, n1, n2);
        System.out.println(d);
    }

    private static int getSubtraction(int b, int n1, int n2) {
        int i=0, borrow = 0, sub = 0;

        while(n2!=0) {
            int remainder_n1 = n1 % 10;
            int remainder_n2 = n2 % 10;

            remainder_n2 += borrow;

            int remainder = 0;

            if(remainder_n2 >= remainder_n1) {
                borrow = 0;
                remainder = remainder_n2 - remainder_n1;
            } else {
                borrow = -1;
                remainder = remainder_n2 + b - remainder_n1;
            }

            sub += (int) Math.pow(10, i++) * (remainder);

            n1 /= 10;
            n2 /= 10;
        }
        return sub;
    }
}
