package question5;

import java.util.LinkedList;

public class Q5 {

    // This method swap the values in i-th element with j-th item
    public <T> LinkedList<T> swap_value(LinkedList<T> lst, int i, int j){
        if (i < 0 | j < 0 | i >= lst.size() | j >= lst.size()) throw new IndexOutOfBoundsException("Invalid index");

        T temp = lst.get(i);
        lst.set(i, lst.get(j));
        lst.set(j, temp);

        return lst;
    }

    public void testQ5(){
        System.out.println("First approach - Only swapping values in LinkedList collection: ");

        LinkedList<Integer> lst = new LinkedList<>();
        lst.add(0);
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        System.out.println("Original LinkedList: " + lst);

        swap_value(lst, 0, 4);
        System.out.println("LinkedList after swaping element i = 0 and j = 4: " + lst);

        System.out.println("--------------------------------------------");

        System.out.println("Second approach - Swapping at node level: ");

        MyLinkedList<String> my_lst = new MyLinkedList<>();
        my_lst.add("zero");
        my_lst.add("One");
        my_lst.add("Two");
        my_lst.add("Three");
        my_lst.add("Four");
        my_lst.add("Five");
        System.out.println("Original LinkedList: ");
        my_lst.print();

        System.out.println("LinkedList after swaping node i = 1 and j = 5: ");
        my_lst.swap(1, 5);
        my_lst.print();

    }
}
