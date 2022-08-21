// https://nados.io/question/string-compression

import java.util.Scanner;

public class StringCompression {

    public static String compression1(String str) {
        String compressed = ""+str.charAt(0);

        for(int i=1; i<str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);
            if(curr != prev) {
                compressed += curr;
            }
        }

        return compressed;
    }
    private static String compression2(String str) {
        String compressed = ""+str.charAt(0);
        int count = 1;

        for(int i=1; i<str.length(); i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);

            if(curr == prev) {
                count += 1;
            } else {
                compressed += count != 1? count : "";
                compressed += curr;
                count = 1;
            }
        }
        compressed += count != 1? count : "";

        return compressed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String compressedString1 = compression1(str);
        String compressedString2 = compression2(str);

        System.out.println(compressedString1);
        System.out.println(compressedString2);
    }

}
