package inheritance;

public class Main {
    public static void main(String[] args) {
        // Create an Acquaintance
        Acquaintance acquaintance = new Acquaintance("John");
        acquaintance.getStatus();

        // Create a Friend
        Friend friend = new Friend("Alice", "New York");
        friend.getStatus();

        // Create a BestFriend
        BestFriend bestFriend = new BestFriend("Bob", "Los Angeles", "Imagine");
        bestFriend.getStatus();
    }
}
