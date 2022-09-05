import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElementOnLeft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        nextSmallerElementLR(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void nextSmallerElementLR(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++) {
            int val = arr[i];
            while(st.size()!=0 && st.peek() >= val) {
                st.pop();
            }
            if(st.size() == 0)
                arr[i] = -1;
            else
                arr[i] = st.peek();
            st.push(val);
        }
    }

    private static void nextSmallerElementRL(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1; i>=0; i--) {
            while(st.size()!=0 && arr[i] < arr[st.peek()]) {
                arr[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while(st.size()!=0) {
            arr[st.pop()] = -1;
        }
    }
}
