package Applications;// https://nados.io/question/largest-area-histogram

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(largestArea(arr));
    }

    public static int[] nextSmallerElementOnLeft(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            while(st.size()!=0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if(st.size()==0)
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }

    public static int[] nextSmallerElementOnRight(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(st.size()!=0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if(st.size()==0)
                res[i] = n;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }

    public static int largestArea(int[] arr) {
        int[] nsor = nextSmallerElementOnRight(arr);
        int[] nsol = nextSmallerElementOnLeft(arr);

        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            int area = arr[i] * (nsor[i]-nsol[i]-1);
            if(max < area) {
                max = area;
            }
        }
        return max;
    }
}
