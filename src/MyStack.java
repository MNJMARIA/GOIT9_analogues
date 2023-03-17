import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyStack<T> {
    private T[] stack;
    private int size;
    private int top;

    public MyStack()
    {

    }
    public MyStack(int capacity) {
        this.stack = (T[]) new Object[capacity];
        this.size = 0;
        this.top = -1;
    }

    public void push(T value) throws IllegalStateException // додає елемент в кінець
    {
        resizeIfNeed();
        if(isFull())
        {
            throw new IllegalStateException("Stack is full!");
        }
        else {
            top++;
            stack[top] = value;
            size++;
        }
        trimToSize();
    }
    public void remove(int index) // видаляє елемент за індексом
    {
        Objects.checkIndex(index, size); // перевіряємо чи попадаємо в масив індексом
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
        T[] newStack = (T[]) new Object[size - 1]; // масив на 1 менший
        System.arraycopy(stack, 0, newStack, 0, index); // копіюємо до індексу який видаляємо
        System.arraycopy(stack, index + 1, newStack, index, size - index - 1); // копіюємо після індексу який видаляємо
        stack = newStack;
        size--;
        top--;
    }
    public void clear() // очищає колекцію
    {
        while (!isEmpty()) {
            pop();
        }
        trimToSize();
    }
    public int size() // повертає розмір колекції
    {
        return size;
    }
    public T peek() // повертає перший елемент стеку
    {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
        return stack[top];
    }
    public T pop() throws NoSuchElementException // повертає перший елемент стеку та видаляє його з колекції
    {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty!");
        }
        T value = stack[top];
        stack[top] = null;
        top--;
        size--;
        trimToSize();
        return value;
    }
    private boolean isEmpty() {
        return size == 0;
    }
    private boolean isFull() {
        return size == stack.length;
    }
    private void resizeIfNeed() {
        if(size == stack.length)
        {
            System.out.println("Resize happened!");
            T[] newStack = (T[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, stack.length);
            stack = newStack;
        }
    }
    private void trimToSize() {
        if (size < stack.length) {
            T[] newStack = (T[]) new Object[size];
            System.arraycopy(stack, 0, newStack, 0, size);
            stack = newStack;
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
