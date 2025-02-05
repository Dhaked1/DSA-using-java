import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				st.push(ch);
			} else if (ch == ')') {
				boolean val = handleClosing(st, '(');
				if (!val) {
					System.out.println(false);
					return;
				}
			} else if (ch == ']') {
				boolean val = handleClosing(st, '[');
				if (!val) {
					System.out.println(false);
					return;
				}
			} else if (ch == '}') {
				boolean val = handleClosing(st, '{');
				if (!val) {
					System.out.println(false);
					return;
				}
			}
		}

		// If stack is empty after processing all characters, the string is balanced
		if (st.size() == 0) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}

	public static boolean handleClosing(Stack<Character> st, char correspond) {
		if (st.size() == 0) {
			return false; // Unmatched closing bracket
		} else if (st.peek() != correspond) {
			return false; // Mismatched bracket
		} else {
			st.pop(); // Match found, pop from stack
			return true;
		}
	}
}