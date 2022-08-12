// https://nados.io/question/inverse-of-an-array

import java.util.Scanner;

public class InverseOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[arr[i]] = i;
        }
        for (int num : res) {
            System.out.println(num);
        }
    }
}
