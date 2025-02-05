import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> vs = new Stack<>();
        Stack<String> is = new Stack<>();
        Stack<String> ps = new Stack<>();

        System.out.println("Enter the postfix expression (digits and operators only, no spaces):");
        String exp = br.readLine().trim();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isDigit(ch)) {
                
                vs.push(ch - '0');
                is.push(ch + "");
                ps.push(ch + "");
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                
                if (vs.size() < 2) {
                    System.out.println("Invalid postfix expression: Not enough operands for operator '" + ch + "'");
                    return;
                }

                
                int v2 = vs.pop();
                int v1 = vs.pop();
                int val = operation(v1, v2, ch);
                vs.push(val);

                
                String iv2 = is.pop();
                String iv1 = is.pop();
                String ival = "(" + iv1 + ch + iv2 + ")";
                is.push(ival);

                String pv2 = ps.pop();
                String pv1 = ps.pop();
                String pval = ch + pv1 + pv2;
                ps.push(pval);
            } else {
               
                System.out.println("Invalid character in expression: " + ch);
                return;
            }
        }

        if (vs.size() != 1) {
            System.out.println("Invalid postfix expression: Too many operands.");
        } else {
            System.out.println("Result: " + vs.pop());
            System.out.println("Infix Expression: " + is.pop());
            System.out.println("Prefix Expression: " + ps.pop());
        }
    }

    public static int operation(int v1, int v2, char op) {
        switch (op) {
            case '+':
                return v1 + v2;
            case '-':
                return v1 - v2;
            case '*':
                return v1 * v2;
            case '/':
                if (v2 == 0) throw new ArithmeticException("Division by zero");
                return v1 / v2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}