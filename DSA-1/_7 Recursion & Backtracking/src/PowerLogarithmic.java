// https://nados.io/question/power-logarithmic

import java.util.Scanner;

public class PowerLogarithmic {

    public static int power(int x, int n) {
        if(n==0)
            return 1;

        int xpnb2 = power(x, n/2);
        int xn = xpnb2 * xpnb2;

        if(n%2!=0)
            xn *= x;

        return xn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(power(x, n));
    }
}
