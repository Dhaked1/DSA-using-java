import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> vs = new Stack<>();  
        Stack<String> is = new Stack<>();  
        Stack<String> ps = new Stack<>();   
        String[] tokens = exp.split(" ");

        
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                if (vs.size() < 2) {
                    throw new IllegalArgumentException("Invalid prefix expression");
                }

                int v1 = vs.pop();
                int v2 = vs.pop();
                int val = operation(v1, v2, token.charAt(0));
                vs.push(val);

                String inv1 = is.pop();
                String inv2 = is.pop();
                String inval = "(" + inv1 + token + inv2 + ")";
                is.push(inval);

                String pov1 = ps.pop();
                String pov2 = ps.pop();
                String poval = pov1 + pov2 + token;
                ps.push(poval);
            } else {
                vs.push(Integer.parseInt(token));
                is.push(token);
                ps.push(token);
            }
        }

        if (vs.size() != 1 || is.size() != 1 || ps.size() != 1) {
            throw new IllegalArgumentException("Invalid prefix expression");
        }

        System.out.println(vs.pop()); // Evaluated value
        System.out.println(is.pop()); // Infix expression
        System.out.println(ps.pop()); // Postfix expression
    }

    public static int operation(int v1, int v2, char op) {
        if (op == '+') {
            return v1 + v2;
        } else if (op == '-') {
            return v1 - v2;
        } else if (op == '*') {
            return v1 * v2;
        } else {
            if (v2 == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return v1 / v2;
        }
    }
}