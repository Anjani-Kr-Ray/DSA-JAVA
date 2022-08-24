// https://nados.io/question/get-subsequence

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(getSubsequence(str));
    }

    private static ArrayList<String> getSubsequence(String str) {
        if(str.length() == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }

        ArrayList<String> res = getSubsequence(str.substring(1));
        ArrayList<String> final_res = new ArrayList<>(res);
        for(String s: res) {
            final_res.add(str.charAt(0)+s);
        }
        return final_res;
    }
}
