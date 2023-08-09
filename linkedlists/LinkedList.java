package linkedlists;

public class LinkedList {

    public static void main(String[] args) {
        // Write your code here:
        LinkedList myList = new LinkedList();
        myList.addToHead("sissy");
        myList.printList();
    }

    public Node head;

    public LinkedList() {
        this.head = null;
    }

    public void addToHead(String data) {
        Node newHead = new Node(data);
        Node currentHead = this.head;
        this.head = newHead;
        if (currentHead != null) {
            this.head.setNextNode(currentHead);
        }
    }

    public void addToTail(String data) {
        Node tail = this.head;
        if (tail == null) {
            this.head = new Node(data);
        } else {
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(new Node(data));
        }
    }

    public String removeHead() {
        Node removedHead = this.head;
        if (removedHead == null) {
            return null;
        }
        this.head = removedHead.getNextNode();
        return removedHead.data;
    }

    // void reverse() {
    //     Node prev = null;
    //     Node current = head;
    //     Node next = null;

    //     while (current != null) {
    //         next = current.getNextNode();  // Store the next node
    //         current.setNextNode(prev);    // Reverse the current node's pointer
    //         prev = current;               // Move prev to the current node
    //         current = next;               // Move current to the next node
    //     }

    //     head = prev; // Set the head of the reversed list as prev
    // }

     public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.getNextNode();  // Store the next node
            current.setNextNode(prev);    // Reverse the current node's pointer
            prev = current;               // Move prev to the current node
            current = next;               // Move current to the next node
        }

        return prev; // Set the head of the reversed list as prev
    }

    public String printList() {
        String output = "<head> ";
        Node currentNode = this.head;
        while (currentNode != null) {
            output += currentNode.data + " ";
            currentNode = currentNode.getNextNode();
        }
        output += "<tail>";
        System.out.println(output);
        return output;
    }

}
