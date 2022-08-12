// https://nados.io/question/first-index-and-last-index

import java.util.Scanner;

public class FirstLastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int fi = -1, li = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                if (fi == -1) {
                    fi = i;
                }
                li = i;
            }
        }

        System.out.println(fi+"\n"+li);
    }
}
