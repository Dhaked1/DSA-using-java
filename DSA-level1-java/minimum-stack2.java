import java.util.*;

public class Main {
    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            if (data.isEmpty()) {
                data.push(val);
                min = val;
            } else if (val >= min) {
                data.push(val);
            } else {
                data.push(val + val - min); 
                min = val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                if (data.peek() >= min) {
                    return data.peek();
                } else {
                    return min; 
                }
            }
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                if (data.peek() >= min) {
                    return data.pop();
                } else {
                    int oldMin = min;
                    int encodedVal = data.pop();
                    min = 2 * min - encodedVal; 
                    return oldMin;
                }
            }
        }

        int getMin() { 
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return min;
            }
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(3);
        stack.push(7);
        System.out.println("Min: " + stack.getMin()); // 3
        System.out.println("Top: " + stack.top());    // 7
        System.out.println("Popped: " + stack.pop()); // 7
        System.out.println("Min: " + stack.getMin()); // 3
        System.out.println("Popped: " + stack.pop()); // 3
        System.out.println("Min: " + stack.getMin()); // 5
    }
}