import com.bounteous.employee.Employee;
import com.bounteous.employee.Processor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sourceFile = "src/resources/employees.txt";

        List<Employee<String>> employees = Processor.read(sourceFile, s -> s);

        Processor.print(employees);
    }
}