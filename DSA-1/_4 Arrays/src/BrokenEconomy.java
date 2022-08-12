// https://nados.io/question/broken-economy

/*
    A point to note is that it is a binary search problem but as I haven't learnt about Binary Search
    so for now I have used normal iteration to solve this problem.
*/
import java.util.Arrays;
import java.util.Scanner;

public class BrokenEconomy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        // we get sorted array as input. But I have made sure that it is sorted :)
        Arrays.sort(arr);

        int index = -1;
        for(int i=0; i<n; i++) {
            if(arr[i] == k) {
                System.out.println(k+"\n" + k);
                return;
            }

            if(arr[i] > k) {
                index = i;
                break;
            }
        }
        System.out.println(arr[index]);
        System.out.println(arr[index-1]);
    }
}
