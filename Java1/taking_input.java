import java.util.Scanner; 

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in); 
        int n = Integer.parseInt(scn.nextLine());
        String name = scn.nextLine(); 
        System.out.println("integer " + n);
        System.out.println("Hello " + name);
    }
}