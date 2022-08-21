// https://nados.io/question/print-all-palindromic-substrings

import java.util.Scanner;

public class PrintAllPalindromicStrings {
    public static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while(i<j) {
            if(str.charAt(i) != str.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for(int i=0; i<str.length(); i++) {
            String substr = "";
            for(int j=i; j<str.length(); j++) {
                substr += str.charAt(j);
                if(isPalindrome(substr))
                    System.out.println(substr);
            }
        }
    }
}
