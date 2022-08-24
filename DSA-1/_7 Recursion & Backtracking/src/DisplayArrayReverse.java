// https://nados.io/question/display-array-in-reverse

import java.util.Scanner;

public class DisplayArrayReverse {

    public static void display(int[] arr, int i) {
        if(i == arr.length)
            return;
        display(arr, i+1);
        System.out.println(arr[i]);
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
