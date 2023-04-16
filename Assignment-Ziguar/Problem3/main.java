class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class LinkedList {
    Node head;

    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    int getMiddle() {
        Node slow_ptr = head;
        Node fast_ptr = head;

        if (head != null) {
            while (fast_ptr != null && fast_ptr.next != null) {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
            return slow_ptr.data;
        }
        return -1;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 11; i > 0; --i) {
            list.push(i);
        }
        System.out.println("The middle element is " + list.getMiddle());
    }
}
