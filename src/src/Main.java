import com.shaghayegh.robot.PhoneType;
import com.shaghayegh.robot.Robot;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot();

        while (true){
            // Get Message and phone type
            System.out.print("Enter your message and phone type (T9 or QWERTY), separated by a comma - enter 1 to exit: ");
            String input = scanner.nextLine();

            if (input.equals("1")){
                System.out.println("Goodbye!");
                break;
            }

            String[] parts = input.split(",");
            String message = parts[0];
            String type = parts.length > 1 ? parts[1].trim() : null;

            PhoneType phoneType = null;
            if (type.equalsIgnoreCase("T9")) {
                phoneType = PhoneType.T9;
            } else if (type.equalsIgnoreCase("QWERTY")) {
                phoneType = PhoneType.QWERTY;
            } else {
                System.err.println("Invalid phone type! You can choose between T9 or QWERTY.");
                System.exit(1);
            }

            // send message
            robot.sendMessage(message, phoneType);

        }
    }
}