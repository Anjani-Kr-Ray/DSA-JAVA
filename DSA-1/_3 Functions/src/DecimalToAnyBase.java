// https://nados.io/question/decimal-to-any-base

import java.util.Scanner;

public class DecimalToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b){
        int i = 0, baseNumber = 0;
        while(n!=0) {
            int remainder = n % b;
            baseNumber += (int) Math.pow(10, i++) * remainder;
            n = n / b;
        }
        return baseNumber;
    }
}
