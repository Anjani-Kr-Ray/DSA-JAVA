// https://nados.io/question/digits-of-a-number

import java.util.Scanner;

public class DigitsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // print from back
        /*
        while(n != 0) {
            int digit = n % 10;
            System.out.println(digit);
            n = n / 10;
        }
        */

        // print from first
        int digits = (int) (Math.log10(n) + 1);

        while(digits != 0) {
            int div = (int) Math.pow(10, digits - 1);
            System.out.println(n/div);
            n = n % div;
            digits--;
        }
    }
}
