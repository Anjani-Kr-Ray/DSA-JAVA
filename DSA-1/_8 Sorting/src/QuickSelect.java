// https://nados.io/question/quick-select

import java.util.Scanner;

public class QuickSelect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(quickSelect(arr, 0, n-1, k-1));
    }

    public static int quickSelect(int[] arr, int p, int q, int k) {
        int r = partition(arr, p, q);
        if(r < k)
            return quickSelect(arr, r+1, q, k);
        else if(r > k)
            return quickSelect(arr, p, r-1, k);
        return arr[r];
    }

    public static int partition(int[] arr, int p, int q) {
        int pivot = arr[p];
        int i = p;
        for(int j=p+1; j<=q; j++) {
            if(arr[j] <= pivot) {
                i+=1;
                swap(arr, i, j);
            }
        }
        swap(arr, i, p);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
