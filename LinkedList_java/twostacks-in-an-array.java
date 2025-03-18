import java.io.*;
import java.util.*;

public class Main {
    public static class TwoStack {
        int[] data;
        int tos1;
        int tos2;

        // Constructor
        public TwoStack(int cap) {
            data = new int[cap];
            tos1 = -1;
            tos2 = data.length;
        }

        // Push operations
        void push1(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } else {
                tos1++;
                data[tos1] = val;
            }
        }

        void push2(int val) {
            if (tos2 == tos1 + 1) {
                System.out.println("Stack overflow");
            } else {
                tos2--;
                data[tos2] = val;
            }
        }

        // Size operations
        int size1() {
            return tos1 + 1;
        }

        int size2() {
            return data.length - tos2;
        }

        // Top operations
        int top1() {
            if (size1() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos1];
            }
        }

        int top2() {
            if (size2() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return data[tos2];
            }
        }

        // Pop operations
        int pop1() {
            if (size1() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos1];
                tos1--; // Fixed bug here
                return val;
            }
        }

        int pop2() {
            if (size2() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data[tos2];
                tos2++;
                return val;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking stack size input
        System.out.print("Enter the capacity of the two stacks: ");
        int cap = sc.nextInt();
        TwoStack ts = new TwoStack(cap);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push in Stack 1");
            System.out.println("2. Push in Stack 2");
            System.out.println("3. Pop from Stack 1");
            System.out.println("4. Pop from Stack 2");
            System.out.println("5. Get Top of Stack 1");
            System.out.println("6. Get Top of Stack 2");
            System.out.println("7. Get Size of Stack 1");
            System.out.println("8. Get Size of Stack 2");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push in Stack 1: ");
                    int val1 = sc.nextInt();
                    ts.push1(val1);
                    break;
                case 2:
                    System.out.print("Enter value to push in Stack 2: ");
                    int val2 = sc.nextInt();
                    ts.push2(val2);
                    break;
                case 3:
                    System.out.println("Popped from Stack 1: " + ts.pop1());
                    break;
                case 4:
                    System.out.println("Popped from Stack 2: " + ts.pop2());
                    break;
                case 5:
                    System.out.println("Top of Stack 1: " + ts.top1());
                    break;
                case 6:
                    System.out.println("Top of Stack 2: " + ts.top2());
                    break;
                case 7:
                    System.out.println("Size of Stack 1: " + ts.size1());
                    break;
                case 8:
                    System.out.println("Size of Stack 2: " + ts.size2());
                    break;
                case 9:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}