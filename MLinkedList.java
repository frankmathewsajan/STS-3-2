public class MLinkedList { 

    Node head; 

    static class Node { 
        int data; 
        Node next; 

        Node(int d) { 
            data = d; 
            next = null; 
        } 
    } 

    public static MLinkedList insert(MLinkedList list, int data) { 
        Node newNode = new Node(data); 
        if (list.head == null) { 
            list.head = newNode; 
        } else { 
            Node last = list.head; 
            while (last.next != null) { 
                last = last.next; 
            } 
            last.next = newNode; 
        } 
        return list; 
    } 

    public static void printList(MLinkedList list) { 
        Node currNode = list.head; 
        System.out.print("MLinkedList: "); 
        while (currNode != null) { 
            System.out.print(currNode.data + " "); 
            currNode = currNode.next; 
        } 
        System.out.println();
    } 

    public static void main(String[] args) { 
        MLinkedList l = new MLinkedList();  
		for (int i = 1; i <= 8; i++) {
			l = insert(l, i); 
		}
        printList(l); 
    } 
}
