// https://nados.io/question/subsets-of-array

import java.util.Scanner;

public class SubsetArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            String set = "";
            int temp = i;
            for(int j=arr.length-1; j>=0; j--) {
                int r = temp%2;

                if(r==0) {
                    set = "-\t" + set;
                } else {
                    set = arr[j] + "\t" + set;
                }
                temp = temp/2;
            }
            System.out.println(set);
        }
    }
}
