
class DLL1 {

    static class Node {

        int data, p;
        Node prev = null, next = null;

        public Node(int d, int p) {
            this.data = d;
            this.p = p;
        }

    }

    static class PQ {

        Node head = null;

        void push(int d, int p) {
            Node n = new Node(d, p);
            if (head == null) {
                head = n;
                return;
            }
            Node t = head;
            while (t != null && t.p <= p) {
                t = t.next;
            }
            if (t == head) {
                n.next = head;
                head.prev = n;
                head = n;
            } else if (t == null) {
                Node tail = head;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = n;
                n.prev = tail;
            } else {
                Node x = t.prev;
                x.next = n;
                n.prev = x;
                n.next = t;
                t.prev = n;

            }
        }

        int pop() {
            if (head == null) {
                return -1;
            }
            int removed = head.data;
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return removed;

        }

        void print() {
            Node t = head;
            while (t != null) {
                System.out.print("(" + t.data + ", " + t.p + ") ");
                t = t.next;
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        PQ pq = new PQ();
        pq.push(180, 5);
        pq.push(240, 2);
        pq.push(567, 10);
        pq.push(765, 7);
        pq.print();
        System.out.println(pq.pop());
        pq.print();
    }
}
