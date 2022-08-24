// https://nados.io/question/print-subsequence

import java.util.Scanner;

public class PrintSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printSubsequence(str, "");
    }

    public static void printSubsequence(String str, String res) {
        if(str.length() == 0) {
            System.out.println(res);
            return;
        }
        printSubsequence(str.substring(1), res+str.substring(0, 1));
        printSubsequence(str.substring(1), res);
    }
}
