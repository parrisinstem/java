package inheritance;

// Class BestFriend
public class BestFriend extends Friend {
    protected String favoriteSong;

    public BestFriend(String name, String homeTown, String favoriteSong) {
        super(name, homeTown);
        this.favoriteSong = favoriteSong;
    }

    public void getStatus() {
        System.out.println(name + " is my best friend. He is from " + homeTown + " and his favorite song is " + favoriteSong + ".");
    }
}
