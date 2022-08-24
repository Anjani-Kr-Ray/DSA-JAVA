// https://nados.io/question/get-stair-paths

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetStairPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getPaths(n));
    }

    public static ArrayList<String> getPaths(int n) {
        if(n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }

        ArrayList<String> res = new ArrayList<>();

        if(n-1 >= 0) {
            ArrayList<String> temp = getPaths(n-1);
            for(int i=0; i<temp.size(); i++) {
                res.add(1+temp.get(i));
            }
        }
        if(n-2 >= 0) {
            ArrayList<String> temp = getPaths(n-2);
            for(int i=0; i<temp.size(); i++) {
                res.add(2+temp.get(i));
            }
        }
        if(n-3 >= 0) {
            ArrayList<String> temp = getPaths(n-3);
            for(int i=0; i<temp.size(); i++) {
                res.add(3+temp.get(i));
            }
        }

        return res;
    }
}
