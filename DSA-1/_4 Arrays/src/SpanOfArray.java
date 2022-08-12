// https://nados.io/question/span-of-array

import java.util.Scanner;

public class SpanOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(int num: arr) {
            if(num < min)
                min = num;
            if(num > max)
                max = num;
        }

        System.out.println(max - min);
    }
}
