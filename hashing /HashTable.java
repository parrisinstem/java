import java.util.Hashtable;

// put(K key, V value): Inserts a key-value pair into the hash table. If the key already exists, the associated value is updated.

// get(Object key): Retrieves the value associated with the specified key. Returns null if the key is not found.

// remove(Object key): Removes the key-value pair with the specified key from the hash table.

// containsKey(Object key): Checks if the hash table contains the specified key. Returns true if the key is found, otherwise false.

// isEmpty(): Checks if the hash table is empty. Returns true if the hash table has no key-value pairs, otherwise false.

// size(): Returns the number of key-value pairs in the hash table.

// clear(): Removes all key-value pairs from the hash table, making it empty.

// keySet(): Returns a Set containing all the keys in the hash table.

// values(): Returns a Collection containing all the values in the hash table.

// entrySet(): Returns a Set containing all the key-value pairs (entries) in the hash table as Map.Entry objects.

public class HashTable {
    public static void main(String[] args) {
        // Create a Hashtable with keys of type String and values of type Integer
        Hashtable<String, Integer> scores = new Hashtable<>();

        // Add key-value pairs to the Hashtable
        scores.put("Alice", 85);
        scores.put("Bob", 90);
        scores.put("Charlie", 78);
        scores.put("David", 92);
        scores.put("Eva", 87);

        // Access values using keys
        System.out.println("Bob's score: " + scores.get("Bob")); // Output: Bob's score: 90

        // Check if a key exists in the Hashtable
        System.out.println("Is Alice in the Hashtable? " + scores.containsKey("Alice")); // Output: Is Alice in the Hashtable? true

        // Remove a key-value pair
        scores.remove("Charlie");

        // Iterate through the keys and values in the Hashtable
        for (String name : scores.keySet()) {
            int score = scores.get(name);
            System.out.println(name + ": " + score);
        }

        // Get the number of key-value pairs in the Hashtable
        System.out.println("Number of entries in the Hashtable: " + scores.size());
    }
}
