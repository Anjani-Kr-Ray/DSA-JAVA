// https://nados.io/question/digit-frequency

import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequency(int n, int d) {
        int c = 0;
        while(n!=0) {
            int digit = n % 10;
            if(d == digit) c++;
            n = n / 10;
        }
        return c;
    }
}
