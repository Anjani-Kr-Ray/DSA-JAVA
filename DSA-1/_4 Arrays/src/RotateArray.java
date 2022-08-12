// https://nados.io/question/rotate-an-array

import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int k = sc.nextInt();

        rotate(arr, k);
        for(int num: arr)
            System.out.print(num+" ");
    }

    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = ((n-k)%n + n) % n;

        reverse(arr, 0, k-1);
        reverse(arr, k, n-1);
        reverse(arr, 0, n-1);
    }

    public static void reverse(int[] arr, int i, int j) {
        while(i<j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
