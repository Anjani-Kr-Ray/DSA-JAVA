// https://nados.io/question/first-index

import java.util.Scanner;

public class FirstIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int num = sc.nextInt();

        System.out.println(firstIndex(arr, 0, num));
    }

    private static int firstIndex(int[] arr, int i, int num) {
        if(i==arr.length)
            return -1;
        if(arr[i] == num)
            return i;
        return firstIndex(arr, i+1, num);
    }
}
