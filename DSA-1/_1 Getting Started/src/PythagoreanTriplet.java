// https://nados.io/question/pythagorean-triplet

import java.util.Scanner;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int max = Math.max(a, Math.max(b, c));
        boolean flag = false;

        if(max == a) {
            flag = ((b*b + c*c) == (a*a));
        } else if(max == b) {
            flag = ((a*a + c*c) == (b*b));
        } else {
            flag = ((b*b + a*a) == (c*c));
        }

        System.out.println(flag);
    }
}
