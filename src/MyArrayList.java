
import java.util.StringJoiner;

public class MyArrayList<T> {
    private static final int INIT_SIZE = 5;
    private Object[] data;
    private int indexOfSize;

    public MyArrayList()
    {
        data = new Object[INIT_SIZE];
    }
    public void add(T value)
    {
        resizeIfNeed();
        data[indexOfSize] = value;
        indexOfSize++;
    }
    private void resizeIfNeed()
    {
        if(indexOfSize == data.length)
        {
            System.out.println("Resize happened, indexOfSize " + indexOfSize);
            int newSize = data.length * 2;
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0,newData, 0, data.length);
            data = newData;
        }
    }
    public void remove(int index)
    {
        int sizeOfStartArray = index;
        int sizeOfEndArray = size() - index - 1;
        Object[] tempStartArray = new Object[sizeOfStartArray];
        Object[] tempEndArray = new Object[sizeOfEndArray];
        Object[] newArray = new Object[data.length - 1];

        System.arraycopy(data, 0, tempStartArray, 0, index);
        System.arraycopy(data, index+1, tempEndArray, 0, data.length);

        ////////////////newArray =

    }
    public void clear()
    {

    }
    public int size()
    {
        return indexOfSize;
    }
    public T get(int i)
    {
        return (T) data[i];
        //TODO А якщо і<0 або i>data.length
    }


    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
        for(int i =0; i < indexOfSize; i++)
        {
            result.add(data[i].toString());
        }
        return "[" + result + "]";
    }
}
