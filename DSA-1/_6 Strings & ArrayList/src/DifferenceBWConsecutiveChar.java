// https://nados.io/question/string-with-difference-of-every-two-consecutive-characters

import java.util.Scanner;

public class DifferenceBWConsecutiveChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String result = ""+str.charAt(0);
        for(int i=1; i<str.length(); i++) {
            int diff = str.charAt(i) - str.charAt(i-1);
            result += diff;
            result += str.charAt(i);
        }
        System.out.println(result);
    }
}
