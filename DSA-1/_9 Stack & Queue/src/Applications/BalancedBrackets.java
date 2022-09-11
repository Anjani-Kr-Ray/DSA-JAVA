package Applications;// https://nados.io/question/balanced-brackets

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(checkBalanceBrackets(str));
    }

    private static boolean checkBalanceBrackets(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch=='(' || ch=='{' || ch=='[') {
                s.push(ch);
            } else if(ch==')') {
                if(!handleClosing(s, '('))
                    return false;
            } else if(ch=='}') {
                if(!handleClosing(s, '{'))
                    return false;
            } else if(ch==']') {
                if(!handleClosing(s, '['))
                    return false;
            }
        }

        return s.size() == 0;
    }

    public static boolean handleClosing(Stack<Character> s, char ch) {
        if(s.size()!=0 && ch==s.peek()) {
            s.pop();
            return true;
        }
        return false;
    }
}
