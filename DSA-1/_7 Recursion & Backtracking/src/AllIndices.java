// https://nados.io/question/all-indices-of-array

import java.util.Arrays;
import java.util.Scanner;

public class AllIndices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int num = sc.nextInt();
        int[] res = allIndices(arr, 0, num, 0);
        if(res.length == 0)
        {
            System.out.println("NO OUTPUT");
            return;
        }
        for(int val: res)
            System.out.println(val);
    }

    // Method 1: Create new array if another occurrence of x is found
    public static int[] allIndices(int[] arr, int i, int x) {
        if (i == arr.length) {
            return new int[0];
        }

        int[] res = allIndices(arr, i+1, x);

        if(arr[i] == x) {
            int[] temp = new int[res.length + 1];
            int idx = 0;
            temp[idx++] = i;
            for(int j=0; j<res.length; j++) {
                temp[idx++] = res[j];
            }
            return temp;
        }
        return res;
    }

    // Method 2: Count all occurrence of x and create new array at base case and return to other calls and fill indices
    public static int[] allIndices(int[] arr, int i, int x, int fsf) {
        if (i == arr.length) {
            return new int[fsf];
        }

        if(arr[i] == x) {
            int[] res = allIndices(arr, i+1, x, fsf+1);
            res[fsf] = i;
            return res;
        }
        return allIndices(arr, i+1, x, fsf);
    }
}
