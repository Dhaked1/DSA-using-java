import java.util.*;

public class Main {
    public static class MinStack {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }

        int size() {
            return allData.size();
        }

        void push(int val) {
            allData.push(val);
            if (minData.isEmpty() || val <= minData.peek()) {
                minData.push(val);
            }
        }

        int min() {
            if (allData.isEmpty()) {
                throw new IllegalStateException("Stack underflow");
            }
            return minData.peek();
        }

        int top() {
            if (allData.isEmpty()) {
                throw new IllegalStateException("Stack underflow");
            }
            return allData.peek();
        }

        int pop() {
            if (allData.isEmpty()) {
                throw new IllegalStateException("Stack underflow");
            }
            int val = allData.pop();
            if (val == minData.peek()) {
                minData.pop();
            }
            return val;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        System.out.println("Min: " + stack.min()); 
        stack.pop();
        System.out.println("Min: " + stack.min()); 
        System.out.println("Top: " + stack.top()); 
    }
}