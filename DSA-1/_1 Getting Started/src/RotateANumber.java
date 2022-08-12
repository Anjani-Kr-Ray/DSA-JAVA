// https://nados.io/question/rotate-a-number

import java.util.Scanner;

public class RotateANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int digits = (int)(Math.log10(n)) + 1;

        k = k % digits;
        if(k < 0) {
            k = k + digits;
        }
        int div = (int) Math.pow(10, k);
        int mul = (int) Math.pow(10, digits - k);

        int quotient = n / div;
        int remainder = n % div;

        int result = remainder * mul + quotient;

        System.out.println(result);

    }
}
