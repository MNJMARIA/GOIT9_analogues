import java.util.StringJoiner;

public class MyHashMap <K, V> {
    // Вкладений клас, що представляє вузол мапи
    private static class Node <K, V>{
        private K key;
        private V value;
        private Node <K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    // Константа, що визначає початковий розмір мапи
    private static final int DEFAULT_CAPACITY = 16;
    private Node <K, V> [] table;
    private int size;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) // Додає ключ та значення до мапи
    {
        int index = hash(key);
        Node <K, V> node = table[index];

        // Перевірка, чи ключ вже є в мапі
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        // Create a new node with the key-value pair and add it to the map
        Node <K, V> newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }
    public void remove(K key)
    {
        int index = hash(key);
        Node <K, V> node = table[index];
        Node <K, V> prev = null;

        // Find the node with the given key and remove it
        while (node != null) {
            if (node.key.equals(key)) {
                if (prev == null) {
                    table[index] = node.next;
                } else {
                    prev.next = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }
    public void clear()
    {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }
    public int size()
    {
        return size;
    }
    public V get(K key)
    {
        int index = hash(key);
        Node <K, V> node = table[index];

        // Find the node with the given key and return its value
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }

        // Key not found in the map
        return null;
    }
    private int hash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (Node <K, V> node : table) {
            while (node != null) {
                result.add("(" + node.key.toString() + ", " + node.value.toString() + ")");
                node = node.next;
            }
        }
        return "[" + result + "]";
    }
}
