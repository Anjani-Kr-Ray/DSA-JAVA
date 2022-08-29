// https://nados.io/question/merge-sort

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    public static int[] merge(int[] a, int[] b){
        //write your code here
        int m = a.length;
        int n = b.length;

        int[] res = new int[m+n];
        int i=0, j=0, k=0;
        while(i<m && j<n) {
            if(a[i] < b[j])
                res[k++] = a[i++];
            else
                res[k++] = b[j++];
        }
        while(i<m) {
            res[k++] = a[i++];
        }
        while(j<n) {
            res[k++] = b[j++];
        }

        return res;
    }
    public static int[] mergeSort(int[] arr, int i, int j) {
        if(i==j) {
            int[] res = new int[1];
            res[0] = arr[i];
            return res;
        }
        int mid = (i + j) / 2;
        int[] first_arr = mergeSort(arr, i, mid);
        int[] second_arr = mergeSort(arr, mid+1, j);
        return merge(first_arr, second_arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(mergeSort(arr, 0, n-1)));
    }

}
