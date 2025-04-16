public class Main {
    public static void main(String[] args) {
        // SortedSet usage
        SortedSet sorter = new SortedSet();
        sorter.sort();

        System.out.println("===========================================");

        // ArithmeticException usage
        ArithmeticException arithmetic = new ArithmeticException();
        arithmetic.testDivide();
    }
}