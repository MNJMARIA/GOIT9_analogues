import java.util.Objects;
import java.util.StringJoiner;

public class MyLinkedList<T> {
    private static class Node<T>{
        private T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }
    private Node<T> first;
    private Node<T> last;
    private int size;
    public void add(T value)
    {
        Node<T> newNode = new Node<> (value); //коли треба додати елемент нам потрібно
                                              // створити новий вузол, тобто новий Node

        //Якщо перший вузол (first) є null - тобто список порожній,
        // тоді змінній first і last присвоюється значення newNode.
        // Це означає, що newNode є єдиним елементом у списку.
        if(first == null)
        {
            first = last = newNode;
        }
        else{
            last.next = newNode; //причіплюємо в кінець новий вузол
                                // засетивши значення посилання next останнього елемента
            last = newNode; //змінили поле last
        }
        size++;
    }
    public T remove(int index)
    {
        Objects.checkIndex(index, size); // перевіряємо чи попадаємо в масив індексом
        T removedElement;
        if(index == 0)  // якщо видаляється перший елемент
        {
            removedElement = first.element;
            first = first.next; // зсуваємо початковий елемент вправо
            if(first == null) // якщо  в нас був лише 1 елемент в списку і ми його видалили, тоді посиланння на настпуний елемент не буде
            {
                last = null;
            }
        }
        else // якщо видаляється НЕ перший елемент
        {
            Node<T> previous = getNodeByIndex(index - 1);  //знайшли попередню ноду
            removedElement = previous.next.element; //зберігаємо елемент який будемо видаляти
            previous.next = previous.next.next; // вказуємо на наступний елемент
            // (пропускаєм ссилку на елемент який хочемо видалити)
            if(index == size - 1)//якщо ми видаляємо останній елемент
            {
                last = previous;
            }
        }
        size--;
        return removedElement;
    }
    public void clear()
    {
        first = last = null;
        size = 0;
    }
    public int size()
    {
        return size;
    }
    public T get(int index)
    {
        Objects.checkIndex(index, size);
        return getNodeByIndex(index).element;
    }
    private Node<T> getNodeByIndex(int index)
    {
        Node<T> current = first;
        for(int i = 0; i < index; i++)
        {
            current = current.next;
        }
        return current;
    }
   @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ");
       Node<T> current = first;
       while (current != null) {
           result.add(current.element.toString());
           current = current.next;
       }
       return "[" + result + "]";
    }


}
