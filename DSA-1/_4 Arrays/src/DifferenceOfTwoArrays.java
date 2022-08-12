// https://nados.io/question/difference-of-two-arrays

import java.util.Scanner;

public class DifferenceOfTwoArrays {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++)
            arr1[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++)
            arr2[i] = sc.nextInt();

        int[] diff = new int[m];

        int borrow = 0, i = n - 1, j = m - 1;

        while(j >= 0) {
            int d = 0;
            int a1val = i >= 0? arr1[i]: 0;

            d = arr2[j] - a1val + borrow;

            if (d < 0) {
                borrow = -1;
                d += 10;
            } else {
                borrow = 0;
            }

            diff[j] = d;
            i--; j--;
        }

        int idx = 0;
        while(idx < diff.length) {
            if(diff[idx] == 0)
                idx++;
            else
                break;
        }

        for(int k=idx; k<diff.length; k++)
            System.out.println(diff[k]);
    }
}
