// https://nados.io/question/target-sum-pair-1

import java.util.Arrays;
import java.util.Scanner;

public class TargetSumPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        printPairs(arr, target);
    }

    public static void printPairs(int[] arr, int target) {
        Arrays.sort(arr);
        int l=0, h=arr.length-1;
        while(l<h) {
            int sum = arr[l] + arr[h];
            if(sum < target)
                l++;
            else if(sum > target)
                h--;
            else {
                System.out.println(arr[l] + ", " + arr[h]);
                l++;
                h--;
            }
        }
    }
}
