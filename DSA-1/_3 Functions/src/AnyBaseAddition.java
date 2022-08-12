// https://nados.io/question/any-base-addition

import java.util.Scanner;

public class AnyBaseAddition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    public static int getSum(int b, int n1, int n2){
        // write ur code here
        int sum = 0, i=0, carry = 0;
        while(n1!=0 || n2!=0 || carry!=0) {
            int remainder_n1 = n1 % 10;
            int remainder_n2 = n2 % 10;

            int remainder = (remainder_n1 + remainder_n2 + carry) % b;
            carry = (remainder_n1 + remainder_n2 + carry) / b;

            sum += (int) Math.pow(10, i++) * remainder;

            n1 /= 10;
            n2 /= 10;
        }
        return sum;
    }
}
