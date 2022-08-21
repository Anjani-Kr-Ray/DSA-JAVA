// https://nados.io/question/power-linear

import java.util.Scanner;

public class PowerLinear {
    public static int powerLinear(int x, int n) {
        if(n==0)
            return 1;
        return x * powerLinear(x, n-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(powerLinear(x, n));
    }
}
