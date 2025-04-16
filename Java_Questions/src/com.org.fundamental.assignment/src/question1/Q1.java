package question1;

public class Q1 {
    public String replace(String original, String regex, String replacement){
        return original.replaceAll(regex, replacement);
    }

    public void testQ1(){
        System.out.println("Test Case 1:");
        String original = "aaaabbab ababbbb";
        String regex = "ab";
        String replacement = "AB";

        System.out.println("Original string is: " + original);
        System.out.println("Regular Expression is: " + regex);
        System.out.println("Replacement string is: " + replacement);
        System.out.println("Output after replacing regex with replacement: " + replace(original, regex, replacement));

        System.out.println("--------------------------------------------");
        System.out.println("Test Case 2:");
        System.out.println("Original string is: " + original);
        System.out.println("Regular Expression is: empty string \"\" ");
        System.out.println("Replacement string is: " + replacement);
        System.out.println("Output after replacing regex with replacement: " + replace(original, "", replacement));

        System.out.println("--------------------------------------------");
        System.out.println("Test Case 3:");
        String original2 = "Hi, I'm shaghayegh. Contact me via shaghayegh.ghasemi@bounteous.com.";
        String regex2 = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        String replacement2 = "email";

        System.out.println("Original string is: " + original2);
        System.out.println("Regular Expression is: " + regex2);
        System.out.println("Replacement string is: " + replacement2);
        System.out.println("Output after replacing regex with replacement: " + replace(original2, regex2, replacement2));

    }
}
