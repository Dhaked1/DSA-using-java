public class LinkedList {  
    Node head;  

    static class Node {  
        int data;  
        Node next;  

        Node(int data) {  
            this.data = data;  
            this.next = null;  
        }  
    }  

    // Method to add an element at the end of the LinkedList  
    public void addLast(int data) {  
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

    // Method to print the LinkedList  
    public void printList() {  
        Node temp = head;  
        while (temp != null) {  
            System.out.print(temp.data + " ");  
            temp = temp.next;  
        }  
        System.out.println();  
    }  

    // Method to merge two sorted LinkedLists  
    public static LinkedList mergeTwoSortedList(LinkedList l1, LinkedList l2) {  
        Node one = l1.head;  
        Node two = l2.head;  
        LinkedList res = new LinkedList();  

        // Traverse both linked lists  
        while (one != null && two != null) {  
            if (one.data < two.data) {  
                res.addLast(one.data);  
                one = one.next;  
            } else {  
                res.addLast(two.data);  
                two = two.next;  
            }  
        }  

        // Add remaining elements of l1  
        while (one != null) {  
            res.addLast(one.data);  
            one = one.next;  
        }  

        // Add remaining elements of l2  
        while (two != null) {  
            res.addLast(two.data);  
            two = two.next;  
        }  

        return res;  
    }  

    // Method to find the middle node of a linked list  
    public static Node midNode(Node head, Node tail) {  
        Node f = head;  
        Node s = head;  
        while (f != tail && f.next != tail) {  
            f = f.next.next;  
            s = s.next;  
        }  
        return s;  
    }  

    // Merge Sort Function  
    public static LinkedList mergesort(Node head, Node tail) {  
        if (head == tail) {  
            LinkedList br = new LinkedList();  
            br.addLast(head.data);  
            return br;  
        }  

        Node mid = midNode(head, tail);  
        LinkedList fsh = mergesort(head, mid);  
        LinkedList ssh = mergesort(mid.next, tail);  
        LinkedList c1 = LinkedList.mergeTwoSortedList(fsh, ssh);  
        return c1;  
    }  

    public static void main(String[] args) {  
        LinkedList l1 = new LinkedList();  
        l1.addLast(5);  
        l1.addLast(3);  
        l1.addLast(8);  
        l1.addLast(2);  
        l1.addLast(6);  

        System.out.println("Unsorted List: ");  
        l1.printList();  

        // Find the tail of the LinkedList  
        Node tail = l1.head;  
        while (tail.next != null) {  
            tail = tail.next;  
        }  

        // Sort the Linked List using Merge Sort  
        LinkedList sortedList = mergesort(l1.head, tail);  
        System.out.println("Sorted List: ");  
        sortedList.printList();  
    }  
}