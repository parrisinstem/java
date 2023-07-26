package doublelinkedlists;

public class example {
    class Node {
        private int value;
        private Node nextNode;
        private Node prevNode;
        
        public Node(int value, Node nextNode, Node prevNode) {
            this.value = value;
            this.nextNode = nextNode;
            this.prevNode = prevNode;
        }
        
        public void setNext(Node nextNode) {
            this.nextNode = nextNode;
        }
        
        public Node getNext() {
            return nextNode;
        }
        
        public void setPrev(Node prevNode) {
            this.prevNode = prevNode;
        }
        
        public Node getPrev() {
            return prevNode;
        }
        
        public int getValue() {
            return value;
        }
    }
    
    class DoublyLinkedList {
        private Node headNode;
        private Node tailNode;
        
        public DoublyLinkedList() {
            this.headNode = null;
            this.tailNode = null;
        }
        
        // Add a new node at the head of the list
        public void addHead(int newValue) {
            Node newHead = new Node(newValue, this.headNode, null);
            Node currentHead = this.headNode;
    
            if (currentHead != null) {
                currentHead.setPrev(newHead);
                newHead.setNext(currentHead);
            }
    
            this.headNode = newHead;
    
            if (this.tailNode == null) {
                this.tailNode = newHead;
            }
        }
    
        // Add a new node at the tail of the list
        public void addTail(int newValue) {
            Node newTail = new Node(newValue, null, this.tailNode);
            Node currentTail = this.tailNode;
    
            if (currentTail != null) {
                currentTail.setNext(newTail);
                newTail.setPrev(currentTail);
            }
    
            this.tailNode = newTail;
    
            if (this.headNode == null) {
                this.headNode = newTail;
            }
        }
    
        // Remove the head node from the list and return its value
        public int removeHead() {
            Node removingHead = this.headNode;
    
            if (removingHead == null) {
                return -1; // Or any other appropriate value to indicate the list is empty
            }
    
            this.headNode = removingHead.getNext();
    
            if (this.headNode != null) {
                this.headNode.setPrev(null);
            }
    
            if (removingHead == this.tailNode) {
                removeTail();
            }
    
            return removingHead.getValue();
        }
    
        // Remove the tail node from the list and return its value
        public int removeTail() {
            Node removingTail = this.tailNode;
    
            if (removingTail == null) {
                return -1; // Or any other appropriate value to indicate the list is empty
            }
    
            this.tailNode = removingTail.getPrev();
    
            if (this.tailNode != null) {
                this.tailNode.setNext(null);
            }
    
            if (removingTail == this.headNode) {
                removeHead();
            }
    
            return removingTail.getValue();
        }
    
        // Remove the first node with the specified value from the list and return the removed node
        public Node removeValue(int removingValue) {
            Node removingNode = null;
            Node currentNode = this.headNode;
    
            while (currentNode != null) {
                if (currentNode.getValue() == removingValue) {
                    removingNode = currentNode;
                    break;
                }
    
                currentNode = currentNode.getNext();
            }
    
            if (removingNode == null) {
                return null;
            }
    
            if (removingNode == this.headNode) {
                removeHead();
            } else if (removingNode == this.tailNode) {
                removeTail();
            } else {
                Node nextNode = removingNode.getNext();
                Node prevNode = removingNode.getPrev();
                nextNode.setPrev(prevNode);
                prevNode.setNext(nextNode);
            }
    
            return removingNode;
        }
    
        // Convert the list to a string representation
        public String stringifyList() {
            StringBuilder stringList = new StringBuilder();
            Node currentNode = this.headNode;
    
            while (currentNode != null) {
                if (currentNode.getValue() != -1) { // Assuming -1 indicates a null value
                    stringList.append(currentNode.getValue()).append("\n");
                }
    
                currentNode = currentNode.getNext();
            }
    
            return stringList.toString();
        }
    }
    

}