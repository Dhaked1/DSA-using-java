import java.io.*;
import java.util.*;

public class Main {
    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val); 
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }

            int val = mainQ.remove(); 

            
            Queue<Integer> temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;

            return val;
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            }

            while (mainQ.size() > 1) {
                helperQ.add(mainQ.remove());
            }

            int val = mainQ.peek(); 
            helperQ.add(mainQ.remove()); 
            Queue<Integer> temp = mainQ;
            mainQ = helperQ;
            helperQ = temp;

            return val;
        }
    }

    public static void main(String[] args) {
        QueueToStackAdapter stack = new QueueToStackAdapter();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top()); // Should print 30
        System.out.println("Popped element: " + stack.pop()); // Should print 30
        System.out.println("Popped element: " + stack.pop()); // Should print 20
        System.out.println("Stack size: " + stack.size()); // Should print 1
    }
}