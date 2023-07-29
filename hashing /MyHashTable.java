//open addressing using linear probing

class MyHashTable<K, V> {
    private int capacity;
    private Object[] keys;
    private Object[] values;

    public MyHashTable(int capacity) {
        this.capacity = capacity;
        this.keys = new Object[capacity];
        this.values = new Object[capacity];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);
        while (keys[index] != null) {
            index = (index + 1) % capacity;
        }
        keys[index] = key;
        values[index] = value;
    }

    public V get(K key) {
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % capacity;
        }
        return (V) values[index];
    }

    public boolean containsKey(K key) {
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % capacity;
        }
        return keys[index] != null;
    }

    public void remove(K key) {
        int index = hash(key);
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % capacity;
        }
        if (keys[index] != null) {
            keys[index] = null;
            values[index] = null;
        }
    }

    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>(10);

        // Insert key-value pairs into the hash table
        hashTable.put("apple", 5);
        hashTable.put("banana", 10);
        hashTable.put("orange", 8);
        hashTable.put("grapes", 15);
        hashTable.put("kiwi", 3);

        // Retrieve values by keys
        System.out.println("Value of 'apple': " + hashTable.get("apple")); // Output: Value of 'apple': 5
        System.out.println("Value of 'grapes': " + hashTable.get("grapes")); // Output: Value of 'grapes': 15
        System.out.println("Value of 'banana': " + hashTable.get("banana")); // Output: Value of 'banana': 10

        // Check if specific keys exist in the hash table
        System.out.println("Contains 'orange': " + hashTable.containsKey("orange")); // Output: Contains 'orange': true
        System.out.println("Contains 'mango': " + hashTable.containsKey("mango")); // Output: Contains 'mango': false

        // Remove a key-value pair from the hash table
        hashTable.remove("kiwi");

        // Try to retrieve the removed key
        System.out.println("Value of 'kiwi': " + hashTable.get("kiwi")); // Output: Value of 'kiwi': null
    }
}
