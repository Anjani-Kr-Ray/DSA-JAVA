// https://nados.io/question/sort-012

import java.util.Arrays;
import java.util.Scanner;

public class Sort012 {
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

    private static void sort(int[] arr) {
        int l=0, mid=0, h=arr.length-1;
        while(mid<=h) {
            if(arr[mid]==0) {
                swap(arr, l, mid);
                l++;
                mid++;
            } else if(arr[mid]==2) {
                swap(arr, h, mid);
                h--;
            } else {
                mid++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
