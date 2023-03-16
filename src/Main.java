import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList arrayList = new MyArrayList();
        MyLinkedList linkedList = new MyLinkedList();
        MyQueue myQueue = new MyQueue(6); //вказуємо розмір черги
        MyStack myStack = new MyStack(2);
        MyHashMap myHashMap = new MyHashMap();

        {
            //робота MyArrayList
            for(int i = 0; i < 10; i++)
            {
                arrayList.add(i);
            }
            System.out.println("MyArrayList = " + arrayList);
            System.out.println("arrayList.size() = " + arrayList.size());
            System.out.println("arrayList.get() = " + arrayList.get(3));
            System.out.println("arrayList.remove() = " + arrayList.remove(7));
            System.out.println("MyArrayList after changes " + arrayList);
            System.out.println("arrayList.clear() ");
            arrayList.clear();
            System.out.println("MyArrayList after changes " + arrayList + "\n");
        }
        {
            //робота MyLinkedList
            linkedList.add("Java");
            linkedList.add("JavaScript");
            linkedList.add("C#");
            linkedList.add("C++");
            linkedList.add("PHP");
            System.out.println("MyLinkedList = " + linkedList);
            System.out.println("linkedList.size() = " + linkedList.size());
            System.out.println("linkedList.get() = " + linkedList.get(3));
            System.out.println("linkedList.remove() = " + linkedList.remove(2));
            System.out.println("MyLinkedList after changes " + linkedList);
            System.out.println("linkedList.clear()");
            linkedList.clear();
            System.out.println("MyLinkedList after changes " + linkedList + "\n");
        }

        {
            //робота MyQueue
            for(int i = 1; i < 7; i++)
            {
                myQueue.add(i);
            }
            System.out.println("myQueue = " + myQueue);
            System.out.println("myQueue.peek() = " + myQueue.peek());
            System.out.println("myQueue = " + myQueue);
            System.out.println("myQueue.poll() = " + myQueue.poll());
            System.out.println("myQueue after changes " + myQueue);
            System.out.println("myQueue.size() = " + myQueue.size());
            System.out.println("myQueue.clear() ");
            myQueue.clear();
            System.out.println("myQueue after changes " + myQueue + "\n");
        }

        {
            //робота MyStack
            myStack.push("Vlad");
            myStack.push("Anna");
            myStack.push("Timmy");
            myStack.push("Maria");
            myStack.push("Rihanna");
            System.out.println("myStack = " + myStack);
            System.out.println("myStack.pop() = " + myStack.pop());
            System.out.println("myStack.size() = " + myStack.size());
            System.out.println("myStack.peek() = " + myStack.peek());
            System.out.println("myStack after changes "  + myStack);
            System.out.println("myStack.remove(3)");
            myStack.remove(3);
            System.out.println("myStack after changes " + myStack);
            System.out.println("myStack.clear()");
            myStack.clear();
            System.out.println("myStack after changes " + myStack + "\n");
        }

        {
            //робота MyHashMap
            myHashMap.put("Junior", 700);
            myHashMap.put("Middle", 1500);
            myHashMap.put("Senior", 2500);
            System.out.println("myHashMap = " + myHashMap);
            System.out.println("myHashMap.size() = " + myHashMap.size());
            System.out.println("myHashMap.get(\"Junior\") = " + myHashMap.get("Junior"));
            System.out.println("myHashMap.remove(\"Senior\")");
            myHashMap.remove("Senior");
            System.out.println("myHashMap after changes " + myHashMap);
            System.out.println("myHashMap.clear()" );
            myHashMap.clear();
            System.out.println("myHashMap after changes " + myHashMap);
        }

    }

}