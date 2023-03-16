import java.util.Arrays;
import java.util.StringJoiner;

public class MyHashMap {
    // Вкладений клас, що представляє вузол мапи
    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }
    // Константа, що визначає початковий розмір мапи
    private static final int DEFAULT_CAPACITY = 16;
    private Node[] table;
    private int size;

    public MyHashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(Object key, Object value) // Додає ключ та значення до мапи
    {
        int index = hash(key);
        Node node = table[index];

        // Перевірка, чи ключ вже є в мапі
        while (node != null) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }

        // Create a new node with the key-value pair and add it to the map
        Node newNode = new Node(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;
    }
    public void remove(Object key)
    {
        int index = hash(key);
        Node node = table[index];
        Node prev = null;

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
    public Object get(Object key)
    {
        int index = hash(key);
        Node node = table[index];

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
    private int hash(Object key) {
        return Math.abs(key.hashCode() % table.length);
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for (Node node : table) {
            while (node != null) {
                result.add("(" + node.key.toString() + ", " + node.value.toString() + ")");
                node = node.next;
            }
        }
        return "[" + result + "]";
    }
}
