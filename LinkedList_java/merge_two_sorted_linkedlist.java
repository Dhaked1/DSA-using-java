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

    //  Merging two sorted LinkedLists  
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

    public static void main(String[] args) {  
        LinkedList l1 = new LinkedList();  
        l1.addLast(1);  
        l1.addLast(3);  
        l1.addLast(5);  

        LinkedList l2 = new LinkedList();  
        l2.addLast(2);  
        l2.addLast(4);  
        l2.addLast(6);  

        System.out.println("List 1: ");  
        l1.printList();  

        System.out.println("List 2: ");  
        l2.printList();  

        LinkedList mergedList = mergeTwoSortedList(l1, l2);  
        System.out.println("Merged List: ");  
        mergedList.printList();  
    }  
}