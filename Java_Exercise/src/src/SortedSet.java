import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortedSet {

    public void sort(){
        Scanner scanner = new Scanner(System.in);

        Set<Integer> set = new TreeSet<>();

        System.out.println("Enter integers (type -1 to stop): ");
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            set.add(num);
        }

        System.out.println("Sorted numbers:");
        for (int n : set) {
            System.out.println(n);
        }

    }
}
