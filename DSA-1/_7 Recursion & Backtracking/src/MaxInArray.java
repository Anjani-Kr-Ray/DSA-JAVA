// https://nados.io/question/max-of-an-array

import java.util.Scanner;

public class MaxInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(max(arr, 0));
    }
    public static int max(int[] arr, int i) {
        if(i==arr.length) {
            return Integer.MIN_VALUE;
        }
        return Math.max(arr[i], max(arr, i+1));
    }
}
