// https://nados.io/question/count-sort

import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
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
        System.out.println(Arrays.toString(sort(arr, max, min)));
    }

    public static int[] sort(int[] arr, int max, int min) {

        int[] count_arr = new int[max-min+1];

        for(int i=0; i<arr.length; i++) {
            count_arr[arr[i]-min]++;
        }

        // what comes to our mind --> but this isn't count sort
        /**
         *  int i=0;
         *  for(int j=0; j<count_arr.length; j++) {
         *      while(count_arr[j]!=0) {
         *          arr[i++] = j+min;
         *          count_arr[j]--;
         *      }
         *  }
         */

        // step 2: Create a prefix sum array for count_arr
        for(int i=1; i< count_arr.length; i++) {
            count_arr[i] = count_arr[i-1] + count_arr[i];
        }

        // step 3: create result array and iterate from end of the original array. Check the prefix sum of the number you are
        // at and place the number at that index in result array
        int[] res = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--) {
            int index = count_arr[arr[i]-min];
            res[index-1] = arr[i];
            count_arr[arr[i]-min]--;
        }

        return res;
    }
}
