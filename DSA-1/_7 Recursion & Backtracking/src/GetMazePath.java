// https://nados.io/question/get-maze-paths

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetMazePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(getMazePath(0,0,m-1,n-1));
    }

    public static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc) {

        if(sr == dr && sc == dc)
            return new ArrayList<>(Arrays.asList(""));

        ArrayList<String> res = new ArrayList<>();
        if(sc+1<=dc) {
            ArrayList<String> hres = getMazePath(sr, sc + 1, dr, dc);
            for(int i=0; i<hres.size(); i++)
                res.add('h'+hres.get(i));
        }
        if(sr+1<=dr) {
            ArrayList<String> vres = getMazePath(sr+1, sc, dr, dc);
            for(int i=0; i<vres.size(); i++)
                res.add('v'+vres.get(i));
        }

        return res;
    }
}
