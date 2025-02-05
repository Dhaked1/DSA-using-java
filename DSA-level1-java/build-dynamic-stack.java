import java.util.*;

public class Main {
    public static class Customstack {
        int[] data;
        int tos;

        public Customstack(int cap) {
            data = new int[cap];
            tos = -1;
        }

        void push(int val) {
            if (tos == data.length - 1) { // Stack is full, resize
                int[] ndata = new int[2 * data.length];
                System.arraycopy(data, 0, ndata, 0, data.length);
                data = ndata;
            }
            tos++;
            data[tos] = val;
        }

        public int pop() {
            if (tos == -1) {
                System.out.println("Stack underflow");
                return -1;
            }
            int val = data[tos];
            tos--;
            return val;
        }

        public int top() {
            if (tos == -1) {
                System.out.println("Stack is empty");
                return -1;
            }
            return data[tos];
        }

        public void display() {
            if (tos == -1) {
                System.out.println("Stack is empty");
                return;
            }
            for (int i = tos; i >= 0; i--) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        public int size() {
            return tos + 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stack capacity: ");
        int cap = sc.nextInt();

        Customstack stack = new Customstack(cap);

        while (true) {
            System.out.println("\n1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    System.out.println("Popped: " + stack.pop());
                    break;
                case 3:
                    System.out.println("Top: " + stack.top());
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Size: " + stack.size());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}