// https://nados.io/question/print-kpc

import java.util.Scanner;

public class PrintKPC {
    
    private static final String[] keys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printKpc(str, "");
    }
    
    public static void printKpc(String str, String res) {
        if(str.length() == 0) {
            System.out.println(res);
            return;
        }
        
        int index = Integer.parseInt(str.substring(0,1));
        String key = keys[index];
        
        for(int i=0; i<key.length(); i++) {
            char ch = key.charAt(i);
            printKpc(str.substring(1), res+ch);
        }
        
    }
}
