// https://nados.io/question/partition-an-array

import java.util.Arrays;
import java.util.Scanner;

public class PartitionAnArray {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int pivot = sc.nextInt();
        partition(arr,pivot);
        System.out.println(Arrays.toString(arr));
    }

    public static void partition(int[] arr, int pivot) {
        int i=0, j=0;

        while(j<arr.length) {
            if(arr[j] <= pivot) {
                swap(arr, j, i);
                i++;
            }
            j++;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
