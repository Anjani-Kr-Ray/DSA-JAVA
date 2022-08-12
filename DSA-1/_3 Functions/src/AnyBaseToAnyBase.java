// https://nados.io/question/any-base-to-any-base

import java.util.Scanner;

public class AnyBaseToAnyBase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sourceBase = sc.nextInt();
        int  destBase= sc.nextInt();
        int dn = getValue(n, sourceBase, destBase);
        System.out.println(dn);
    }

    private static int getValue(int n, int sb, int db) {
        int decimal = getValueInDecimal(n, sb);
        return getValueInBase(decimal, db);
    }

    private static int getValueInDecimal(int n, int b) {
        int i=0, decimal = 0;
        while(n!=0) {
            int remainder = n % 10;
            decimal += (int) Math.pow(b, i++) * remainder;
            n /= 10;
        }
        return decimal;
    }

    private static int getValueInBase(int n, int b) {
        int i=0, baseNumber = 0;
        while(n!=0) {
            int remainder = n % b;
            baseNumber += (int) Math.pow(10, i++) * remainder;
            n = n / b;
        }
        return baseNumber;
    }
}
