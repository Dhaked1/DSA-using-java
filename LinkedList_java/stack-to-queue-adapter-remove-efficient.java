import java.util.Stack;

public class Main {
    Stack<Integer> mainS = new Stack<>();
    Stack<Integer> helperS = new Stack<>();

    void add(int val) {
        while (mainS.size() > 0) {
            helperS.push(mainS.pop());
        }
        mainS.push(val);
        while (helperS.size() > 0) {
            mainS.push(helperS.pop()); // Fixed `poo()` to `pop()`
        }
    }

    int remove() {
        if (size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        } else {
            return mainS.pop();
        }
    }

    int size() {
        return mainS.size();
    }

    int peek() {
        if (size() == 0) {
            System.out.println("Queue underflow");
            return -1;
        } else {
            return mainS.peek();
        }
    }

    public static void main(String[] args) {
        Main queue = new Main();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.remove()); // Expected Output: 1
        System.out.println(queue.peek());   // Expected Output: 2
    }
}