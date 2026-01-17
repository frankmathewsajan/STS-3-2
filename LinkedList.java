import java.util.*;
public class LinkedList {
    Node head = null;
    Node tail = null;
        
    void insert(int data) {
        Node n = new Node(data);
        if (head==null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    void display() {
        Node t = head;
        while (t!=null) {
            System.out.println(t.data + " ");
            t = t.next;
        }
    }
    class Node {
        Node next = null;
        int data;
        Node(int d) {
            this.data = d;
        }
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            LinkedList list = new LinkedList();
            int e;
            while ((e=sc.nextInt())!=-1) list.insert(e);
            list.display();
        }
    }
}