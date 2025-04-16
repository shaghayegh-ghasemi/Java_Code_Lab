package question4;

import java.io.*;
import java.util.*;

public class TestQ4 {
    Q4 question4 = new Q4(
            "Shaghayegh Ghasemi", 26, "shaghayegh.ghasemi@bounteous.com", "Sh@gh@yegh", "XXX-XXX-XXX"
    );

    public void serialize(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\com.org.fundamental.assignment\\src\\question4\\question4.ser"))){
            out.writeObject(question4);
            System.out.println("Object Q4 was serialized: ");
            System.out.println(question4);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deserialize(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src\\com.org.fundamental.assignment\\src\\question4\\question4.ser"))){
            Q4 deserializedQ4 = (Q4) in.readObject();
            System.out.println("Object Q4 was deserialized: ");
            System.out.println(deserializedQ4);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
