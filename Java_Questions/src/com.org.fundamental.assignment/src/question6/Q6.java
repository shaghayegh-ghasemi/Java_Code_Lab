package question6;

import java.lang.Math;
import java.util.*;
public class Q6 {

    // with time complexity O(N*M)
    public <T> Set<T> intersection(Set<T> a, Set<T> b){
        Set<T> same = new HashSet<>();
        for(T itemA : a){
            for(T itemB : b){
                if(itemA.equals(itemB)) same.add(itemA);
            }
        }
        return same;
    }

    // with time complexity O(N*M)
    public <T> Set<T> intersection_faster(Set<T> a, Set<T> b){
        Set<T> same = new HashSet<>(a);
        same.retainAll(b);
        return same;
    }

    public void testQ6(){
        System.out.println("Test Case 1:");
        Set<String> cars1 = new HashSet<>();
        cars1.add("Volvo");
        cars1.add("BMW");
        cars1.add("Ford");
        cars1.add("Mazda");

        System.out.println("First set: " + cars1);

        Set<String> cars2 = new HashSet<>();
        cars2.add("Volvo");
        cars2.add("BMW");
        cars2.add("Ford");
        cars2.add("Porsche");
        cars2.add("Lamborghini");
        cars2.add("Audi");

        System.out.println("Second set: " + cars2);

        Set<String> sameCars = intersection(cars1, cars2);

        System.out.println("Similar elements in the sets: " + sameCars);

        System.out.println("--------------------------------------------");
        System.out.println("Test Case 2:");
        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);

        System.out.println("First set: " + a);

        Set<Integer> b = new HashSet<>();
        b.add(20);
        b.add(3);
        b.add(17);

        System.out.println("Second set: " + b);

        Set<Integer> sameNumbers = intersection_faster(a, b);

        System.out.println("Similar elements in the sets: " + sameNumbers);

    }
}
