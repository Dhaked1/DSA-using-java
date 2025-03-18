public class LinkedList {
    Node head;
    Node tail;
    int size;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add node at the end of the linked list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Get the first element of the list
    public int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        } else {
            return head.data;
        }
    }

    // Remove the first element of the list
    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
        } else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            head = head.next;
            size--;
        }
    }

    // Remove duplicate elements from the sorted linked list
    public void removeDuplicate() {
        if (head == null) return;

        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
                size--;
            } else {
                temp = temp.next;
            }
        }
        tail = temp; // Update the tail
    }

    // Return the size of the list
    public int size() {
        return size;
    }

    // Display the linked list with arrows
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.addLast(2);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(5);
        l1.addLast(6);
        l1.addLast(6);
        l1.addLast(8);

        System.out.println("Before removing duplicates:");
        l1.display();

        l1.removeDuplicate();

        System.out.println("After removing duplicates:");
        l1.display();
    }
}