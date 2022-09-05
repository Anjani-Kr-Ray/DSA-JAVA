// https://nados.io/question/celebrity-problem

import java.util.Scanner;
import java.util.Stack;

public class FindCelebrity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        findCelebrity(arr);
    }

    public static void findCelebrity(int[][] arr) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i< arr.length; i++)
            st.push(i);
        while(st.size()>1) {
            int i = st.pop();
            int j = st.pop();

            if(arr[i][j] == 1) {
                // if i knows j => i is not celebrity
                st.push(j);
            } else {
                // if i doesn't j => j is not celebrity
                st.push(i);
            }
        }
        int pot = st.pop();
        for(int i=0; i<arr.length; i++) {
            if(i!=pot) {
                if(arr[i][pot]!=1 || arr[pot][i]!=0) {
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(pot);
    }
}
