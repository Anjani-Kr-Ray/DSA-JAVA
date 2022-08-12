// https://nados.io/question/inverse-of-a-number

import java.util.Scanner;

public class InverseOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 0;

        int i = 1;
        while(n!=0) {
            int r = n % 10;
            result += i * (int) Math.pow(10, r-1) ;
            n = n / 10;
            i++;
        }

        System.out.println(result);
    }
}
