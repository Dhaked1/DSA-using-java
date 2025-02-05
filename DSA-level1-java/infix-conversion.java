import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Stack<String> post = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                ops.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                post.push(ch + "");
                pre.push(ch + "");
            } else if (ch == ')') {
                while (ops.size() > 0 && ops.peek() != '(') {
                    char op = ops.pop();
                    processOperator(op, post, pre);
                }
                ops.pop(); 
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (ops.size() > 0 && ops.peek() != '(' && precedence(ch) <= precedence(ops.peek())) {
                    char op = ops.pop();
                    processOperator(op, post, pre);
                }
                ops.push(ch);
            }
        }

        while (ops.size() > 0) {
            char op = ops.pop();
            processOperator(op, post, pre);
        }

        System.out.println(post.pop());
        System.out.println(pre.pop());
    }

    public static void processOperator(char op, Stack<String> post, Stack<String> pre) {
        String postv2 = post.pop();
        String postv1 = post.pop();
        String postv = postv1 + postv2 + op;
        post.push(postv);

        String pre2 = pre.pop();
        String pre1 = pre.pop();
        String prev = op + pre1 + pre2;
        pre.push(prev);
    }

    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}