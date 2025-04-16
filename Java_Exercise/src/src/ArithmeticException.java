public class ArithmeticException extends Throwable {
    private String message;

    public ArithmeticException() {}

    public ArithmeticException(String message) {
        this.message = message;
    }

    public String getMessage() { return message; }

    public int divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public void testDivide() {
        System.out.println("Diving 10 by 0: ");
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);

        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
