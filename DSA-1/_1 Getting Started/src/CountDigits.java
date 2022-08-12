// https://nados.io/question/count-digits-in-a-number

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // normal procedure
        int count = 0;
        while(n != 0) {
            count += 1;
            n = n / 10;
        }
        System.out.println(count);

        // shortcut
        // System.out.println((int) (Math.log10(n)) + 1);
    }
}
