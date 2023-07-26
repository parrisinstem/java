package stacks;

public class example {

    public class Node {
        private String value;
        private Node nextNode;
    
        public Node(String value) {
            this.value = value;
            this.nextNode = null;
        }
    
        public String getValue() {
            return value;
        }
    
        public Node getNextNode() {
            return nextNode;
        }
    
        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }
    }
    
    public class Stack {
        private Node topItem;
        private int size;
        private int limit;
    
        public Stack(int limit) {
            this.topItem = null;
            this.size = 0;
            this.limit = limit;
        }
    
        public void push(String value) {
            if (hasSpace()) {
                Node item = new Node(value);
                item.setNextNode(topItem);
                topItem = item;
                size++;
                System.out.println("Adding " + value + " to the pizza stack!");
            } else {
                System.out.println("No room for " + value + "!");
            }
        }
    
        public String pop() {
            if (!isEmpty()) {
                Node itemToRemove = topItem;
                topItem = itemToRemove.getNextNode();
                size--;
                System.out.println("Delivering " + itemToRemove.getValue());
                return itemToRemove.getValue();
            }
            System.out.println("All out of pizza.");
            return null;
        }
    
        public String peek() {
            if (!isEmpty()) {
                return topItem.getValue();
            }
            System.out.println("Nothing to see here!");
            return null;
        }
    
        public boolean hasSpace() {
            return limit > size;
        }
    
        public boolean isEmpty() {
            return size == 0;
        }
    }
    
    // public class Main {
    //     public static void main(String[] args) {
    //         Stack pizzaStack = new Stack(6);
    //         pizzaStack.push("pizza #1");
    //         pizzaStack.push("pizza #2");
    //         pizzaStack.push("pizza #3");
    //         pizzaStack.push("pizza #4");
    //         pizzaStack.push("pizza #5");
    //         pizzaStack.push("pizza #6");
    
    //         // Uncomment the push() statement below:
    //         // pizzaStack.push("pizza #7");
    
    //         System.out.println("The first pizza to deliver is " + pizzaStack.peek());
    //         pizzaStack.pop();
    //         pizzaStack.pop();
    //         pizzaStack.pop();
    //         pizzaStack.pop();
    //         pizzaStack.pop();
    //         pizzaStack.pop();
    
    //         // Uncomment the pop() statement below:
    //         // pizzaStack.pop();
    //     }
    // }
    
    
}
