// https://nados.io/question/infix-conversions

import java.util.Scanner;
import java.util.Stack;

public class InfixConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        conversion(expr);
    }

    public static int precedence(char operator) {
        if(operator=='+' || operator=='-')
            return 1;
        else
            return 2;
    }

    public static void conversion(String str) {
        Stack<Character> operator = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(Character.isDigit(ch) || Character.isAlphabetic(ch)) {
                prefix.push(ch+"");
                postfix.push(ch+"");
            } else if(ch=='(') {
                operator.push(ch);
            } else if(ch==')') {
                while(operator.peek()!='(') {
                    char oprtr = operator.pop();
                    prefixPostfix(prefix, postfix, oprtr);
                }
                operator.pop();
            } else if(ch=='+' || ch=='-' || ch=='*' || ch=='/') {
                while(operator.size()!=0 && operator.peek()!='(' && precedence(ch) <= precedence(operator.peek())) {
                    char oprtr = operator.pop();
                    prefixPostfix(prefix, postfix, oprtr);
                }
                operator.push(ch);
            }
        }
        while(operator.size()!=0) {
            char oprtr = operator.pop();
            prefixPostfix(prefix, postfix, oprtr);
        }

        System.out.println(postfix.pop());
        System.out.println(prefix.pop());
    }

    public static void prefixPostfix(Stack<String> prefix, Stack<String> postfix, char oprtr) {
        String val2 = prefix.pop();
        String val1 = prefix.pop();
        prefix.push(oprtr+val1+val2);
        val2 = postfix.pop();
        val1 = postfix.pop();
        postfix.push(val1+val2+oprtr);
    }
}
