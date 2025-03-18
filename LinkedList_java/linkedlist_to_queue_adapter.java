import java.io.*;
import java.util.*;

public class Main {
    public static class LLtoQueueAdapter {
        LinkedList<Integer> list;

        public LLtoQueueAdapter() {
            list = new LinkedList<>();
        }

        int size() { 
            return list.size();
        }

        void add(int val) {
            list.addLast(val); 
        }

        int remove() {
            if (this.size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.removeFirst(); 
            }
        }

        int peek() {
            if (this.size() == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return list.getFirst(); 
            }
        }
    }

    public static void main(String[] args) {
        LLtoQueueAdapter q = new LLtoQueueAdapter();

        q.add(10);
        q.add(20);
        System.out.println(q.peek()); // 10
        System.out.println(q.remove()); // 10
        System.out.println(q.peek()); // 20
        System.out.println(q.size()); // 1
        System.out.println(q.remove()); // 20
        System.out.println(q.remove()); 
    }
}