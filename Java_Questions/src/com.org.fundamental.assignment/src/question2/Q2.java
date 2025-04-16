package question2;

import java.util.*;

public class Q2 {
    public <T, K> List<T> reverse(LinkedHashMap<T, K> map){
        ArrayList<T> reversedKey = new ArrayList<>(map.keySet());
        Collections.reverse(reversedKey);
        return reversedKey;
    }

    public void testQ2(){
        System.out.println("Test Case 1:");
        LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("Key 1", 1);
        map1.put("Key 2", 2);
        map1.put("Key 3", 3);
        map1.put("Key 4", 4);
        map1.put("Key 5", 5);
        map1.put("Key 6", 6);

        System.out.println("Original view of the LinkedHashMap: ");
        System.out.println(map1);

        List<String> map1_reverse_key = reverse(map1);

        System.out.println("Map keys in reverse order: ");
        System.out.println(map1_reverse_key);

        System.out.println("--------------------------------------------");
        System.out.println("Test Case 2:");
        LinkedHashMap<Integer, String> map2 = new LinkedHashMap<>();
        map2.put(1, "Value 1");
        map2.put(2, "Value 2");
        map2.put(3, "Value 3");
        map2.put(4, "Value 4");

        System.out.println("Original view of the LinkedHashMap: ");
        System.out.println(map2);

        List<Integer> map2_reverse_key = reverse(map2);

        System.out.println("Map keys in reverse order: ");
        System.out.println(map2_reverse_key);
    }
}
