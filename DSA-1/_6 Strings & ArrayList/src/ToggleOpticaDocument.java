// https://nados.io/question/toggle-optica-document

import java.util.Scanner;

public class ToggleOpticaDocument {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String result = "";

        // Method 1: Simply convert lower to upper and vice-versa
        /*
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch>='A' && ch<='Z')
                result += (char) (ch + 'a' - 'A');
            else if(ch>='a' && ch<='z')
                result += (char) (ch + 'A' - 'a');
        }
        */

        // Method 2: Using Bitwise Operator - The ascii value of small and capital char case is differ by just 1 bit (5th bit).
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            result += (char) (ch ^ (1<<5));
        }
        System.out.println(result);
    }
}
