package question4;

import java.io.Serializable;
import java.util.UUID;

public class Q4 implements Serializable {
    private static final long VersionUID = UUID.randomUUID().getMostSignificantBits();

    private String name;
    private int age;
    private String email;
    private transient String password;
    private transient String SIN;

    public Q4(String name, int age, String email, String password, String SIN){
        this.name = name;
        this.age = age;
        this.email =email;
        this.password = password;
        this.SIN = SIN;
    }

    @Override
    public String toString(){
        return "Content of my class: " +
                "1. Name: " + this.name + " / " +
                "2. Age: " + this.age + " / " +
                "3. Email: " + this.email + " / " +
                "4. Password: " + this.password + " / " +
                "5. SIN number: " + this.SIN + ".";

    }
}
