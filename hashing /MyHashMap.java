import java.util.HashMap;

// put(K key, V value): Inserts a key-value pair into the map. If the key already exists, the associated value is updated.

// get(Object key): Retrieves the value associated with the specified key. Returns null if the key is not found.

// remove(Object key): Removes the key-value pair with the specified key from the map.

// containsKey(Object key): Checks if the map contains the specified key. Returns true if the key is found, otherwise false.

// containsValue(Object value): Checks if the map contains the specified value. Returns true if the value is found, otherwise false.

// isEmpty(): Checks if the map is empty. Returns true if the map has no key-value pairs, otherwise false.

// size(): Returns the number of key-value pairs in the map.

// clear(): Removes all key-value pairs from the map, making it empty.

// keySet(): Returns a Set containing all the keys in the map.

// values(): Returns a Collection containing all the values in the map.

// entrySet(): Returns a Set containing all the key-value pairs (entries) in the map as Map.Entry objects.

// putAll(Map<? extends K, ? extends V> m): Copies all the mappings from the specified map to this map.

// getOrDefault(Object key, V defaultValue): Returns the value to which the specified key is mapped, or the provided default value if the key is not found.

// putIfAbsent(K key, V value): Inserts a key-value pair into the map only if the specified key is not already associated with a value.

// replace(K key, V value): Replaces the value for a given key with the specified value.

// computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction): Computes the value for a given key using the provided mapping function and inserts it into the map if the key is not already associated with a value.

// computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction): Computes a new value for the given key using the provided remapping function if the key is present in the map.

public class MyHashMap {
    public static void main(String[] args) {
        // Create a HashMap with keys of type String and values of type Integer
        HashMap<String, Integer> scores = new HashMap<>();

        // Add key-value pairs to the HashMap
        scores.put("Alice", 85);
        scores.put("Bob", 90);
        scores.put("Charlie", 78);
        scores.put("David", 92);
        scores.put("Eva", 87);

        // Access values using keys
        System.out.println("Bob's score: " + scores.get("Bob")); // Output: Bob's score: 90

        // Check if a key exists in the HashMap
        System.out.println("Is Alice in the HashMap? " + scores.containsKey("Alice")); // Output: Is Alice in the HashMap? true

        // Remove a key-value pair
        scores.remove("Charlie");

        // Iterate through the keys and values in the HashMap
        for (String name : scores.keySet()) {
            int score = scores.get(name);
            System.out.println(name + ": " + score);
        }

        // Get the number of key-value pairs in the HashMap
        System.out.println("Number of entries in the HashMap: " + scores.size());
    }
}
