import question1.Q1;
import question2.Q2;
import question3.Q3;
import question4.TestQ4;
import question5.Q5;
import question6.Q6;

public class Main {
    public static void main(String[] args) {
        // Q1
        System.out.println("Question 1:");
        Q1 question1 = new Q1();
        question1.testQ1();

        System.out.println("=====================================================");

        // Q2
        System.out.println("Question 2:");
        Q2 question2 = new Q2();
        question2.testQ2();

        System.out.println("=====================================================");

        // Q3
        System.out.println("Question 3:");
        Q3 question3 = new Q3();
        question3.count();

        System.out.println("=====================================================");

        // Q4
        System.out.println("Question 4:");
        TestQ4 question4 = new TestQ4();
        question4.serialize();
        question4.deserialize();

        System.out.println("=====================================================");

        // Q5
        System.out.println("Question 5:");
        Q5 question5 = new Q5();
        question5.testQ5();

        System.out.println("=====================================================");

        // Q6
        System.out.println("Question 6:");
        Q6 question6 = new Q6();
        question6.testQ6();

    }
}