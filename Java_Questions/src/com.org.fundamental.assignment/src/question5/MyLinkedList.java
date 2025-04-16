package question5;

public class MyLinkedList<T> {
    Node<T> head;

    // add a new node to the linkedlist
    public void add(T val){
        Node<T> node = new Node<>(val);

        // if linkedlist is empty, this will become head
        if(head == null) head = node;
        else { // if not empty, add this node to the end of linkedlist
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
    }

    // print the linkedlist elements
    public void print() {
        Node<T> curr = this.head;

        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // swap node i with node j
    public void swap(int i, int j){
        if (i == j) return;

        // find node i and its previous node
        Node<T> prevX = null;
        Node<T> x = head;
        for (int k = 0; x != null && k < i; k++){
            prevX = x;
            x = x.next;
        }

        // find node j and its previous node
        Node<T> prevY = null;
        Node<T> y = head;
        for (int k = 0; y != null && k < j; k++){
            prevY = y;
            y = y.next;
        }

        if(x == null || y == null) return;

        if(prevX != null) prevX.next = y; // previous node of x should refer to y
        else head = y; // if x is the head, y should replace it

        // same for y
        if(prevY != null) prevY.next = x;
        else head = x;

        // Now we should handle the next node of x and y
        Node<T> temp = x.next;
        x.next = y.next;
        y.next = temp;

    }
}
