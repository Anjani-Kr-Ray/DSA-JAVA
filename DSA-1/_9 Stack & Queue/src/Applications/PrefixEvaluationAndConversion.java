// https://nados.io/question/prefix-evaluation-and-conversions

package Applications;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluationAndConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expr = sc.nextLine();
        evaluateAndConvert(expr);
    }

    public static void evaluateAndConvert(String expr) {
        Stack<Integer> eval = new Stack<>();
        Stack<String> ic = new Stack<>();
        Stack<String> pc = new Stack<>();

        for(int i=expr.length()-1; i>=0; i--) {
            char ch = expr.charAt(i);
            if(Character.isDigit(ch)) {
                eval.push(Character.getNumericValue(ch));
                ic.push(ch+"");
                pc.push(ch+"");
            } else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                int val1 = eval.pop();
                int val2 = eval.pop();
                eval.push(operation(val1, val2, ch));

                String ival1 = ic.pop();
                String ival2 = ic.pop();
                ic.push('('+ival1+ch+ival2+')');

                String pval1 = pc.pop();
                String pval2 = pc.pop();
                pc.push(pval1+pval2+ch);
            }
        }
        System.out.println(eval.pop());
        System.out.println(ic.pop());
        System.out.println(pc.pop());
    }

    private static Integer operation(int val1, int val2, char ch) {
        if(ch=='+')
            return val1+val2;
        else if(ch=='-')
            return val1-val2;
        else if(ch=='*')
            return val1*val2;
        else
            return val1/val2;
    }
}
