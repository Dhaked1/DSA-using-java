class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {
    private Node head; // Declare head
    private Node pleft; // Pointer for checking palindrome

    private boolean isPalindromeHelper(Node right) {
        if (right == null) {
            return true;
        }

        boolean rres = isPalindromeHelper(right.next);
        if (!rres) {
            return false;
        }
        if (pleft.data != right.data) {
            return false;
        }
        
        pleft = pleft.next;
        return true;
    }

    public boolean isPalindrome() {
        pleft = head; // Initialize pleft before recursion
        return isPalindromeHelper(head);
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public static void main(String[] args) {
        Main list = new Main();
        list.insert(1);
        list.insert(2);
        list.insert(2);
        list.insert(1);

        System.out.println("Is Palindrome: " + list.isPalindrome());
    }
}