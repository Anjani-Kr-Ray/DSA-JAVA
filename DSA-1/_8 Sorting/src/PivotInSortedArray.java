// https://nados.io/question/pivot-in-sorted-and-rotated-array

import java.util.Scanner;

public class PivotInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(pivot(arr));
    }

    private static int pivot(int[] arr) {
        int start=0, end=arr.length-1;
        while(start<end) {
            int mid = start+(end-start)/2;
            if(arr[mid] < arr[end]) {
                end = mid;
            } else {
                start = mid+1;
            }
        }
        return arr[start];
    }
}
