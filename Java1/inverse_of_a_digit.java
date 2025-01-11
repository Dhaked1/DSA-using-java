import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int pos = 1;
        int dig = 0;
        while (n > 0) {
            int rem = n % 10;  
  
            dig = dig + pos* (int)Math.pow(10, rem - 1);  
            pos++;
            n = n / 10;  
        }
        System.out.println(dig);
    }
}