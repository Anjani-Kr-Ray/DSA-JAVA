// https://nados.io/question/print-permutations

import java.util.Scanner;

public class PrintPermutations {

    public static void printPermutation(String str, String res) {
        if(str.length() == 0) {
            System.out.println(res);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            String temp = str.substring(0,i) + str.substring(i+1);
            printPermutation(temp, res+str.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        printPermutation(str, "");
    }
}
