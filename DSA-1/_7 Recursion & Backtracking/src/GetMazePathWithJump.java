// https://nados.io/question/get-maze-path-with-jumps

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GetMazePathWithJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(getPath(0,0,m-1,n-1));
    }
    public static ArrayList<String> getPath(int sr, int sc, int dr, int dc) {
        if(sr==dr && sc==dc)
            return new ArrayList<>(Arrays.asList(""));

        ArrayList<String> path = new ArrayList<>();

        for(int h=1; h<=dc-sc; h++) {
            ArrayList<String> temp = getPath(sr, sc+h, dr, dc);
            for(String hpath: temp) {
                path.add("h"+h+hpath);
            }
        }

        for(int v=1; v<=dr-sr; v++) {
            ArrayList<String> temp = getPath(sr+v, sc, dr, dc);
            for(String vpath: temp) {
                path.add("v"+v+vpath);
            }
        }

        for(int d=1; d<=dc-sc && d<=dr-sr; d++) {
            ArrayList<String> temp = getPath(sr+d, sc+d, dr, dc);
            for(String dpath: temp) {
                path.add("d"+d+dpath);
            }
        }

        return path;
    }
}
