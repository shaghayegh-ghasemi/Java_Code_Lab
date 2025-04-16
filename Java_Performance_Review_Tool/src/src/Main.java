import com.bounteous.employee.Employee;
import com.bounteous.employee.Processor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sourceFile = "src/resources/employees.txt";
        String outputFile = "src/output/report.text";

        List<Employee<String>> employees = Processor.read(sourceFile, s -> s);
        List<Employee<String>> higherRating = Processor.extractHigherRating(employees, 4.0);

        System.out.println("All employees: ");
        Processor.print(employees);

        System.out.println("Employees with higher performance: ");
        Processor.print(higherRating);

        Processor.write(higherRating, outputFile);

    }
}