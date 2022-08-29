// https://nados.io/question/radix-sort

import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int val: arr) {
            max = Math.max(val, max);
        }

        int exp = 1;
        while(exp <= max) {
            countSort(arr, exp);
            exp *= 10;
        }

    }

    public static void countSort(int[] arr, int exp) {

        int[] count_arr = new int[10];

        for(int i=0; i<arr.length; i++) {
            count_arr[arr[i] / exp % 10]++;
        }

        for(int i=1; i< count_arr.length; i++) {
            count_arr[i] = count_arr[i-1] + count_arr[i];
        }

        int[] res = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            int index = count_arr[arr[i] / exp % 10];
            res[index-1] = arr[i];
            count_arr[arr[i] / exp % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
    }
}
