import java.io.*;

public class Main {
    public static class Person {
        int age;
        String name;

        void saysHi() {
            System.out.println(name + "[" + age + "] says hi");
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.age = 10;
        p1.name = "a";
        p1.saysHi();

        Person p2 = new Person();
        p2.age = 20;
        p2.name = "b";
        p2.saysHi();
    }
}