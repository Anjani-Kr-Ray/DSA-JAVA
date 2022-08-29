// https://nados.io/question/sort-01

import java.util.Arrays;
import java.util.Scanner;

public class Sort01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int i=0, pivot=arr[0];

        for(int j=i+1; j<arr.length; j++) {
            if(arr[j] <= pivot) {
                i+=1;
                swap(arr, i, j);
            }
        }
        swap(arr, i, 0);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}