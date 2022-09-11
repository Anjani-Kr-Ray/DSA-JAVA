// https://nados.io/question/postfix-evaluation-and-conversions

package Applications;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluationAndConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        evaluateAndConvert(expr);
    }

    public static void evaluateAndConvert(String expr) {
        Stack<Integer> eval = new Stack<>();
        Stack<String> ic = new Stack<>();
        Stack<String> pc = new Stack<>();

        for(int i=0; i<expr.length(); i++) {
            char ch = expr.charAt(i);
            if(Character.isDigit(ch)) {
                eval.push(ch-'0');
                ic.push(ch+"");
                pc.push(ch+"");
            } else {
                int val2 = eval.pop();
                int val1 = eval.pop();
                eval.push(operation(val1, val2, ch));

                String ival2 = ic.pop();
                String ival1 = ic.pop();
                ic.push('('+ival1+ch+ival2+')');

                String pval2 = pc.pop();
                String pval1 = pc.pop();
                pc.push(ch+pval1+pval2);
            }
        }
        System.out.println(eval.pop());
        System.out.println(ic.pop());
        System.out.println(pc.pop());
    }

    private static Integer operation(int val1, int val2, char operator) {
        if(operator=='+')
            return val1+val2;
        else if(operator=='-')
            return val1-val2;
        else if(operator=='*')
            return val1*val2;
        else
            return val1/val2;
    }
}
