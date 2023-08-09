package linkedlists;

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.addToHead("10");
        myList.addToHead("20");
        myList.addToHead("30");
        myList.addToHead("40");
        myList.addToHead("50");

        System.out.println("Original Linked List:");
        myList.printList();

        myList.reverse();

        System.out.println("Reversed Linked List:");
        myList.printList();
    }
}
