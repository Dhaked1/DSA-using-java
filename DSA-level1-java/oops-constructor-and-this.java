import java.util.*;
public class Main {
	public static class Person{
		int age;
		String name;
		void sayhi()
		{
			System.out.println(name + "[" + age + "]says hi");
		}
		Person()
		{
			//constructor (default constructor)
		}
		Person(int age,String name)
		{
			this.age = age;
			this.name = name;
		}
	}
	
	public static void main(String[] args) {
		Person p1 =  new Person();
		p1.age = 10;
		p1.name = "A";
		p1.sayhi();
		
		Person p2 = new Person(20,"B");
		p2.sayhi();
	}
}