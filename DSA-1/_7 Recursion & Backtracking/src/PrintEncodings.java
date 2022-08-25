// https://nados.io/question/print-encodings

import java.util.Scanner;

public class PrintEncodings {
    public static void printEncodings(String str, String res) {
        if(str.length() == 0) {
            System.out.println(res);
            return;
        } else if(str.length() == 1) {
            if(str.charAt(0) == '0')
                return;
            else {
                int num = str.charAt(0) - '0';
                char code = (char) ('a' + num - 1);
                System.out.println(res + code);
                return;
            }
        } else {
            char ch = str.charAt(0);
            if(ch == '0')
                return;
            else {
                int num = str.charAt(0) - '0';
                char code = (char) ('a' + num - 1);
                printEncodings(str.substring(1), res + code);
            }
            int chi = Integer.parseInt(str.substring(0,2));
            if(chi >=1 && chi <= 26) {
                char code = (char) ('a' + chi - 1);
                printEncodings(str.substring(2), res + code);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        printEncodings(str, "");
    }
}
