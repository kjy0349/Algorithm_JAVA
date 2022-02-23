import java.io.*;

public class Person {
    String p;
    Person(String s){
        p = s;
    }
    public static Person setAgentName(Person p) {
        p = null;
        return p;
    }

    public String getName() {
        return p;
    }

    public static void main(String[] args) throws IOException{
        Person p = new Person("noname");

        setAgentName(p);
        System.out.println(p.getName());  // 1

    }
}
