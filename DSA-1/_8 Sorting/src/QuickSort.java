// https://nados.io/question/quick-sort

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }

    public static int partition(int[] arr, int p, int q) {
        int key = arr[p];
        int i = p;
        for(int j=p+1; j<=q; j++) {
            if(arr[j] <= key) {
                i += 1;
                swap(arr, i, j);
            }
        }
        swap(arr, i, p);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int p, int q) {
        if(p<q) {
            int r = partition(arr, p, q);
            quickSort(arr, p, r-1);
            quickSort(arr, r+1, q);
        }
    }
}
