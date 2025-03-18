import java.io.*;
import java.util.*;

public class Main {
    public static class LLtostackAdapter {
        LinkedList<Integer> list;

        public LLtostackAdapter() {
            list = new LinkedList<>();
        }

        int size() { // Corrected return type
            return list.size();
        }

        void push(int val) {
            list.addFirst(val);
        }

        int pop() {
            if (this.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.removeFirst();
            }
        }

        int top() {
            if (this.size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return list.getFirst();
            }
        }
    }

    public static void main(String[] args) {
        LLtostackAdapter st = new LLtostackAdapter();

        st.push(10);
        st.push(20);
        System.out.println(st.top()); // 20
        System.out.println(st.pop()); // 20
        System.out.println(st.top()); // 10
        System.out.println(st.size()); // 1
        System.out.println(st.pop()); // 10
        System.out.println(st.pop()); // Stack underflow, -1
    }
}