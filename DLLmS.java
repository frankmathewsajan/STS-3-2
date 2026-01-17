
import java.util.*;
public class DLLmS {
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
    
    Node mergeSort(Node h) {
        if (h==null || h.next==null) return h;
        Node m = getM(h);
        Node n = m.next;
        m.next = null;
        if(n!=null) n.prev = null;
        Node l=mergeSort(h), r=mergeSort(n);
        return merge(l, r);
    }
    Node merge(Node a, Node b) {
    if (a == null) return b;
    if (b == null) return a;

    Node th = null, tt = null;

    while (a != null && b != null) {
        Node t;
        if (a.data <= b.data) {
            t = a;
            a = a.next;
        } else {
            t = b;
            b = b.next;
        }

        if (th == null) {
            th = tt = t;
            tt.prev = null;
        } else {
            tt.next = t;
            t.prev = tt;
            tt = t;
        }
    }

    Node rest = (a != null) ? a : b;
    if (rest != null) {
        tt.next = rest;
        rest.prev = tt;
    }

    return th;
}

    Node getM(Node m) {
        if (m == null) return m;
        Node tor = m, rab = m;
        while (rab.next!=null && rab.next.next!=null) {
            tor = tor.next;
            rab = rab.next.next;
        }
        return tor;
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
            DLLmS list = new DLLmS();
            int e;
            while ((e=sc.nextInt())!=-1) list.insert(e);
            list.display();
            list.mergeSort(list.head);
            list.display();
        }
    }
}