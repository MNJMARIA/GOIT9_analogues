import java.util.Arrays;

public class MyQueue<T> {
    private T[] queue;
    private int size;
    private int head; // початок черги
    private int tail; // кінець черги

    public MyQueue(int capacity)
    {
        queue = (T[]) new Object[capacity];
        size = head = tail = 0;
    }

    public void add(T value) throws IllegalStateException
    {
        if(size == queue.length)
        {
            throw new IllegalStateException("Queue is full!");
        }
        else {
            queue[tail] = value;
            tail = (tail + 1)%queue.length; // обчислюємо індекс наступного елемента по модулю з довжиною масиву
                                            // % (оператор залишку) використовуємо дл забезпечення кругового масиву
                                            // (якщо ми досягаємо кінця масиву, ми повертаємося на початок масиву,
                                            // щоб продовжити зберігання елементів у черзі)
            size++;
        }
    }
    public void clear()
    {
        Arrays.fill(queue, null);
        size = head = tail = 0;
        trimToSize();
    }
    public int size()
    {
        return size;
    }
    public T peek() // повертає перший елемент з черги
    {
        return size == 0? null : queue[head];
    }
    public T poll() // повертає перший елемент з черги і видаляє його з колекції
    {
        if (size == 0) {
            return null;
        }
        T value = queue[head];
        queue[head] = null; // звільняємо пам'ять від видаленого елементу
        head = (head + 1) % queue.length; // обчислюємо індекс наступного елемента по модулю з довжиною масиву
        size--;
        return value;
    }

    private void trimToSize() // зменшення розміру масиву до фактичного розміру черги
    {
        if (size < queue.length) {
            queue = Arrays.copyOf(queue, size);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
