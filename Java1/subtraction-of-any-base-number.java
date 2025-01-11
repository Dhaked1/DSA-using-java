import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the base: ");
        int b = scn.nextInt();
        System.out.print("Enter the first number: ");
        int n1 = scn.nextInt();
        System.out.print("Enter the second number: ");
        int n2 = scn.nextInt();
        int d = getDifference(b, n1, n2);
        System.out.println("The difference is: " + d);
    }

    public static int getDifference(int b, int n1, int n2) {
        int rv = 0; 
        int c = 0;  
        int p = 1;  

        while (n2 > 0) {
            int d1 = n1 % 10; 
            int d2 = n2 % 10; 
            n1 = n1 / 10;     
            n2 = n2 / 10;    

           
            d2 = d2 + c;

            int d = 0;
            if (d2 >= d1) {
                c = 0; 
                d = d2 - d1;
            } else {
                c = -1; 
                d = d2 - d1 + b;
            }

            rv = rv + d * p; 
            p = p * 10;      
        }

        return rv;
    }
}