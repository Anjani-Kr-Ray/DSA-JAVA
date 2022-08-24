// https://nados.io/question/display-array

import java.util.Scanner;

public class DisplayArray {

    public static void display(int[] arr, int i) {
        if(i == arr.length)
            return;
        System.out.println(arr[i]);
        display(arr, i+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        display(arr, 0);
    }
}
