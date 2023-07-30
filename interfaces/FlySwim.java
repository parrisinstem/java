package interfaces;

interface Flying {
    void fly();
}

interface Swimming {
    void swim();
}

class Bird implements Flying {
    @Override
    public void fly() {
        System.out.println("Bird is flying.");
    }
}

class Fish implements Swimming {
    @Override
    public void swim() {
        System.out.println("Fish is swimming.");
    }
}
class Duck implements Flying, Swimming {
    @Override
    public void fly() {
        System.out.println("Duck is flying.");
    }

    @Override
    public void swim() {
        System.out.println("Duck is swimming.");
    }
}
