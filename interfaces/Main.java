package interfaces;

public class Main {
	
	public static void main (String[] args) {
	
		// creating an instance of Bicycle
		// doing some operations
		Bicycle bicycle = new Bicycle();
		bicycle.changeGear(2);
		bicycle.speedUp(3);
		bicycle.applyBrakes(1);
		
		System.out.println("Bicycle present state :");
		bicycle.printStates();
		
		// creating instance of the bike.
		Bike bike = new Bike();
		bike.changeGear(1);
		bike.speedUp(4);
		bike.applyBrakes(3);
		
		System.out.println("Bike present state :");
		bike.printStates();


        Bird bird = new Bird();
        Fish fish = new Fish();
        Duck duck = new Duck();

        bird.fly();  // Output: Bird is flying.
        fish.swim(); // Output: Fish is swimming.
        duck.fly();  // Output: Duck is flying.
        duck.swim(); // Output: Duck is swimming.
	}
}
