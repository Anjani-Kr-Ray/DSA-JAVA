// https://nados.io/question/smallest-number-following-pattern

package Applications;

import java.util.Scanner;
import java.util.Stack;

public class SmallestNumberFollowingPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        printSmallestNumber(pattern);
    }

    public static void printSmallestNumber(String pattern) {
        int count = 1;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if(ch=='d') {
                st.push(count);
                count += 1;
            } else if(ch=='i') {
                st.push(count);
                while(st.size()!=0) {
                    System.out.print(st.pop());
                }
                count += 1;
            }
        }
        st.push(count);
        while(st.size()!=0) {
            System.out.print(st.pop());
        }
    }
}
