// https://nados.io/question/infix-evaluation

import java.util.Scanner;
import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        System.out.println(evaluate(expr));
    }

    public static int evaluate(String str) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)) {
                operands.push(ch-'0');
            } else if(ch=='(') {
                operators.push('(');
            } else if(ch==')') {
                while(operators.peek()!='(') {
                    char opratr = operators.pop();
                    int b = operands.pop();
                    int a = operands.pop();
                    operands.push(operation(a, b, opratr));
                }
                operators.pop();
            } else if(ch=='+' || ch=='-' || ch=='*' || ch=='/') {
                while(operators.size()!=0 && operators.peek()!='(' && precedence(ch) <= precedence(operators.peek())) {
                    char opratr = operators.pop();
                    int b = operands.pop();
                    int a = operands.pop();
                    operands.push(operation(a, b, opratr));
                }
                operators.push(ch);
            }
        }
        while(operators.size()!=0) {
            char opratr = operators.pop();
            int b = operands.pop();
            int a = operands.pop();
            operands.push(operation(a, b, opratr));
        }
        return operands.pop();
    }

    public static int precedence(char operator) {
        if(operator=='+')
            return 1;
        else if(operator=='-')
            return 1;
        else if(operator=='*')
            return 2;
        else
            return 2;
    }
    public static int operation(int a, int b, char operator) {
        if(operator=='+')
            return a+b;
        else if(operator=='-')
            return a-b;
        else if(operator=='*')
            return a*b;
        else
            return a/b;
    }
}
