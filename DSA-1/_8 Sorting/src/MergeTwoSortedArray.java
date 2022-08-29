// https://nados.io/question/merge-two-sorted-arrays

import java.util.Arrays;
import java.util.Scanner;

public class MergeTwoSortedArray {
    public static int[] mergeTwoSortedArrays(int[] a, int[] b){
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

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for(int i = 0 ; i < n; i++){
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for(int i = 0 ; i < m; i++){
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a,b);
        System.out.println(Arrays.toString(mergedArray));
    }
}
