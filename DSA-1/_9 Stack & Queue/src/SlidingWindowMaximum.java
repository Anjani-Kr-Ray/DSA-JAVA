// https://nados.io/question/sliding-window-maximum

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        slidingWindowMax(arr, k);
    }

    public static int[] nextGreaterInRight(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(st.size()!=0 && arr[i] >= arr[st.peek()])
                st.pop();
            if(st.size() == 0)
                res[i] = arr.length;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }

    public static void slidingWindowMax(int[] arr, int k) {
        int[] nge = nextGreaterInRight(arr);
        int j=0;
        for(int i=0; i<=arr.length-k; i++) {
            if(j<i)
                j=i;
            while(nge[j] < i+k) {
                j = nge[j];
            }
            System.out.println(arr[j]);
        }
    }
}
