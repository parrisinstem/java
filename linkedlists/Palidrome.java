package linkedlists;

class PalindromeLinkedList {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.getNextNode() == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;
        while (fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }

        Node secondHalf = reverse(slow.getNextNode());
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.getNextNode();
            secondHalf = secondHalf.getNextNode();
        }

        return true;
    }

 
}