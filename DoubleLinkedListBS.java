//https://docs.google.com/spreadsheets/d/16Ocir4Qe_jzqji2a1KO3y-UZLWjH2HtiVdGede7SHGk/edit?gid=0#gid=0
import java.util.*;
public class DoubleLinkedListBS {
    Node head = null;
    Node tail = null;
        
    void insert(int data) {
        Node n = new Node(data);
        if (head==null) {
            head = n;
            tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = tail.next;
        }
    }

    void display() {
        Node t = head;
        while (t!=null) {
            System.out.print(t.data + " ");
            t = t.next;
        }
        System.out.println();
    }
    class Node {
        Node next = null;
        Node prev = null;
        int data;
        Node(int d) {
            this.data = d;
        }
    }
    
    void bitonicSort() {
        Node bh = null, bt = null;
        while (head!=tail) {
            if (head.data<=tail.data) {
                if (bh==null) {
                    bh = bt = head;
                    head = head.next;
                    bh.next=null;
                } else {
                    Node future = head.next;
                    bt.next = head;
                    head.prev = bt;
                    head.next = null;
                    bt=bt.next;
                    head=future;
                    future.prev = null;
                }
            } else {
                if (bt==null) {
                    bh = bt = tail;
                    tail = tail.prev;
                    bt.prev=null;
                } else {
                    Node future = tail.prev;
                    bt.next = tail;
                    tail.prev = bt;
                    tail.next = null;
                    bt = bt.next;
                    tail = future;
                    future.next = null;
                    
                }
            }
        }
        bt.next = head;
        head.prev = bt;
        bt = bt.next;
        bt.next = null;
        head = bh;
        
    }
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            DoubleLinkedListBS list = new DoubleLinkedListBS();
            int e;
            while ((e=sc.nextInt())!=-1) list.insert(e);
            list.display();
            list.bitonicSort();
            list.display();
        }
    }
}