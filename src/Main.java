public class Main {
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();

        for(int i = 0; i < 10; i++)
        {
            list.add(i);
        }

        System.out.println("MyArrayList = " + list);
        System.out.println("List.size() = " + list.size());
        System.out.println("List.get(3) = " + list.get(3));


    }

}