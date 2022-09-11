// https://nados.io/question/next-greater-element-to-the-right

package Applications;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementOnRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        nextGreaterElementLR(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Iterating from right to left
    public static void nextGreaterElementRL(int[] arr) {
        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
            int val = arr[i];
            while(s.size()!=0 && val >= s.peek()) {
                s.pop();
            }
            if(s.size()==0)
                arr[i] = -1;
            else
                arr[i] = s.peek();
            s.push(val);
        }
    }

    // Iterating from left to right
    public static void nextGreaterElementLR(int[] arr) {
        Stack<Integer> s = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            int val = arr[i];

            while(s.size()!=0 && val >= arr[s.peek()]) {
                int index = s.pop();
                arr[index] = arr[i];
            }
            s.push(i);
        }

        while(s.size()!=0) {
            arr[s.pop()] = -1;
        }
    }
}
