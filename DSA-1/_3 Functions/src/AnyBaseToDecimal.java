// https://nados.io/question/any-base-to-decimal

import java.util.Scanner;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int dn = getValueIndecimal(n, b);
        System.out.println(dn);
    }

    public static int getValueIndecimal(int n, int b){
        int i = 0, decimalNumber = 0;
        while(n!=0) {
            int remainder = n % 10;
            decimalNumber += (int) Math.pow(b, i++) * remainder;
            n /= 10;
        }
        return decimalNumber;
    }
}
