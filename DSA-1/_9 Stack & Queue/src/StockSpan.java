// https://nados.io/question/stock-span

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int[] res = stockSpan(arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] stockSpan(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length; i++) {
            while(st.size()!=0 && arr[i]>arr[st.peek()]) {
                st.pop();
            }
            if(st.size()==0)
                res[i] = i+1;
            else
                res[i] = i - st.peek();
            st.push(i);
        }
        return res;
    }
}
