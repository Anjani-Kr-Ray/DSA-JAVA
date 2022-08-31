// https://nados.io/question/duplicate-brackets

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(checkDuplicateBracket(str));
    }

    public static boolean checkDuplicateBracket(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ')') {
                char top = s.peek();
                if(top == '(') {
                    return true;
                }
                while(s.peek() != '(') {
                    s.pop();
                }
                s.pop();
            } else {
                s.push(ch);
            }
        }
        return false;
    }
}
