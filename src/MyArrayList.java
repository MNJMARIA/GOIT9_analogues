import java.util.Objects;
import java.util.StringJoiner;

public class MyArrayList<T> {
    private static final int INIT_SIZE = 5;
    private Object[] array;
    private int size;

    public MyArrayList()
    {
        array = new Object[INIT_SIZE];
    }
    public void add(T value)
    {
        resizeIfNeed();
        array[size] = value;
        size++;
    }
    private void resizeIfNeed()
    {
        if(size == array.length)
        {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0,newArray, 0, size);
            array = newArray;
        }
    }
    public T remove(int index)
    {
        Objects.checkIndex(index, size);
        T removedElement = (T) array[index];
        System.arraycopy(array, index+1, array, index, size - index - 1);
        size--;
        return removedElement;
    }
    public void clear()
    {
        size = 0;
        array = new Object[INIT_SIZE];
    }
    public int size()
    {
        return size;
    }
    public T get(int index)
    {
        Objects.checkIndex(index, size);
        return (T) array[index];
    }
    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for(int i =0; i < size; i++)
        {
            result.add(array[i].toString());
        }
        return "[" + result + "]";
    }
}
