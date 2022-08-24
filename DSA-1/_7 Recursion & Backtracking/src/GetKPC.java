// https://nados.io/question/get-kpc

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetKPC {

    private final static String[] keys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(getKpc(str));
    }

    public static ArrayList<String> getKpc(String str) {
        if(str.length() == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }

        ArrayList<String> tempRes = getKpc(str.substring(1));
        int index = Integer.parseInt(str.substring(0, 1));
        String key = keys[index];
        ArrayList<String> res = new ArrayList<>();
        for(int i=0; i<key.length(); i++) {
            char ch = key.charAt(i);
            for(int j=0; j<tempRes.size(); j++) {
                res.add(ch+tempRes.get(j));
            }
        }
        return res;
    }
}
