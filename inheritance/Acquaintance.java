package inheritance;

// Class Acquaintance
public class Acquaintance {
    protected String name;

    public Acquaintance(String name) {
        this.name = name;
    }

    public void getStatus() {
        System.out.println(name + " is just an acquaintance.");
    }
}



