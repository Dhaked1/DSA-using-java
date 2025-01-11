import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int dig = 0;

        // Handle negative numbers
        n = Math.abs(n);

        if (n == 0) {
            dig = 1;
        } else {
            while (n != 0) {
                n = n / 10;
                dig++;
            }
        }
        System.out.println(dig);
    }
}