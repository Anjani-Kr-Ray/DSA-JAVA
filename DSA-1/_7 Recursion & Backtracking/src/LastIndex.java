// https://nados.io/question/last-index

import java.util.Scanner;

public class LastIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int num = sc.nextInt();

        System.out.println(lastIndex(arr, 0, num));
    }

    private static int lastIndex(int[] arr, int i, int num) {
        if(i==arr.length)
            return -1;

        int res = lastIndex(arr, i+1, num);

        if(res == -1) {
            if(arr[i] == num)
                return i;
            else
                return -1;
        }

        return res;
    }
}
