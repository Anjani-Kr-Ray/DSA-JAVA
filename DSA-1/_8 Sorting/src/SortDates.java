// https://nados.io/question/sort-dates

import java.util.Arrays;
import java.util.Scanner;

public class SortDates {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            arr[i] = str;
        }
        sortDates(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sortDates(String[] arr) {
        countSort(arr, 1000000, 100, 32);
        countSort(arr, 10000, 100, 13);
        countSort(arr, 1, 10000, 2501);
    }

    public static void countSort(String[] arr,int div, int mod, int range) {
        String[] ans = new String[arr.length];
        int[] farr = new int[range];
        for(int i=0; i<arr.length; i++) {
            farr[Integer.parseInt(arr[i], 10) / div % mod]++;
        }

        for(int i=1; i<farr.length; i++) {
            farr[i]+=farr[i-1];
        }

        for(int i=arr.length-1; i>=0; i--) {
            int index = farr[Integer.parseInt(arr[i], 10) / div % mod] - 1;
            ans[index] = arr[i];
            farr[Integer.parseInt(arr[i], 10) / div % mod]--;
        }

        for(int i=0; i<ans.length; i++) {
            arr[i] = ans[i];
        }
    }
}
