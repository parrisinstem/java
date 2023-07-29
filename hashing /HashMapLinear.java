import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class HashMapLinear<K, V> {
    private static final int DEFAULT_MAXSIZE = 100;
    private K[] keys;
    private V[] values;
    private int size;
    private int maxSize;

    public HashMapLinear() {
        this(DEFAULT_MAXSIZE);
    }

    public HashMapLinear(int maxSize) {
        this.maxSize = maxSize;
        this.keys = (K[]) new Object[maxSize];
        this.values = (V[]) new Object[maxSize];
        this.size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % maxSize;
    }

    public void put(K key, V value) {
        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                values[index] = value; // Update value if key already exists
                return;
            }
            index = (index + 1) % maxSize; // Linear probing
        }

        keys[index] = key;
        values[index] = value;
        size++;

        // Resize the array if load factor exceeds a threshold (e.g., 0.75)
        if ((double) size / maxSize >= 0.75) {
            resize();
        }
    }

    // public V get(K key) {
    //     int index = find(key);
    //     return index != -1 ? values[index] : null;
    // }

      public Optional<V> get(K key) {
        int index = find(key);
        return index != -1 ? Optional.of(values[index]) : Optional.empty();
    }

    public void remove(K key) {
        int index = find(key);
        if (index != -1) {
            keys[index] = null;
            values[index] = null;
            size--;
        }
    }

    public boolean containsKey(K key) {
        return find(key) != -1;
    }

    private int find(K key) {
        int index = hash(key);
        int originalIndex = index;
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return index;
            }
            index = (index + 1) % maxSize; // Linear probing
            if (index == originalIndex) {
                break; // Avoid infinite loop
            }
        }
        return -1; // Key not found
    }

    private void resize() {
        maxSize *= 2;
        K[] newKeys = (K[]) new Object[maxSize];
        V[] newValues = (V[]) new Object[maxSize];

        for (int i = 0; i < keys.length; i++) {
            if (keys[i] != null) {
                int newIndex = hash(keys[i]);
                while (newKeys[newIndex] != null) {
                    newIndex = (newIndex + 1) % maxSize; // Linear probing for new array
                }
                newKeys[newIndex] = keys[i];
                newValues[newIndex] = values[i];
            }
        }

        keys = newKeys;
        values = newValues;
    }

    public List<K> keySet() {
        List<K> keyList = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            if (keys[i] != null) {
                keyList.add(keys[i]);
            }
        }
        return keyList;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        // Create a HashMap with keys of type String and values of type Integer
        HashMapLinear<String, Integer> scores = new HashMapLinear<>();

        // Add key-value pairs to the HashMap
        scores.put("Alice", 85);
        scores.put("Bob", 90);
        scores.put("Charlie", 78);
        scores.put("David", 92);
        scores.put("Eva", 87);

        // // Access values using keys
        // System.out.println("Bob's score: " + scores.get("Bob")); // Output: Bob's score: 90

        // // Check if a key exists in the HashMap
        // System.out.println("Is Alice in the HashMap? " + scores.containsKey("Alice")); // Output: Is Alice in the HashMap? true

        // // Remove a key-value pair
        // scores.remove("Charlie");

        // Access values using keys
        String keyToRetrieve = "Bob";
        
         Optional<Integer> scoreOptional = scores.get(keyToRetrieve);
         System.out.println(keyToRetrieve + "'s score: " + scoreOptional.orElse(0));
 
    
        // Check if a key exists in the HashMap
        String keyToCheck = "Alice";
        System.out.println("Is " + keyToCheck + " in the HashMap? " + scores.containsKey(keyToCheck)); // Output: Is Alice in the HashMap? true

       // Remove a key-value pair
       String keyToRemove = "Charlie";
       boolean removed = scores.containsKey(keyToRemove);
       scores.remove(keyToRemove);
       if (removed) {
           System.out.println(keyToRemove + " removed from the HashMap.");
       } else {
           System.out.println(keyToRemove + " not found in the HashMap.");
       }


        // Iterate through the keys and values in the HashMap
        for (String name : scores.keySet()) {
            //int score = scores.get(name);
            //reassign
            scoreOptional = scores.get(name);
            //System.out.println(name + ": " + score);
            scoreOptional.ifPresent(score -> System.out.println(name + ": " + score));


        }

        // Get the number of key-value pairs in the HashMap
        System.out.println("Number of entries in the HashMap: " + scores.size());
}
}