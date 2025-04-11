import com.shaghayegh.robot.PhoneType;
import com.shaghayegh.robot.Robot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Robot robot = new Robot();

        // Get Message and phone type
        System.out.print("Enter your message and phone type, separated by a comma: ");
        String input = scanner.nextLine();
        String[] parts = input.split(",");
        String message = parts[0];
        String type = parts.length > 1 ? parts[1].trim() : null;

        PhoneType phoneType = null;
        if (type.equals("T9")) {
            phoneType = PhoneType.T9;
        } else if (type.equals("QWERTY")) {
            phoneType = PhoneType.QWERTY;
        } else {
            System.out.println("Invalid phone type! You can choose between T9 or QWERTY.");
        }

        // send message
        robot.sendMessage(message, phoneType);
    }
}