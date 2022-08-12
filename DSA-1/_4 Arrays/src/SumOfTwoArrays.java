// https://nados.io/question/sum-of-two-arrays

import java.util.Arrays;
import java.util.Scanner;

public class SumOfTwoArrays {
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

        int res_size = Math.max(n, m) ;
        int[] res = new int[res_size];

        int i=n-1, j=m-1, k = res_size - 1, c = 0;
        while(k>=0) {
            int d = c;
            if(i>=0)
                d+=arr1[i];
            if(j>=0)
                d+=arr2[j];
            c = d / 10;
            d = d % 10;

            res[k] = d;
            i--; j--; k--;
        }

        if(c!=0)
            System.out.println(c);

//        System.out.println(Arrays.toString(res));
        Arrays.stream(res).forEach(System.out::println);
    }
}
