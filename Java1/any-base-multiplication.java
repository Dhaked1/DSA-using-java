import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();  // Base of the numbers
        int n1 = scn.nextInt(); // First number
        int n2 = scn.nextInt(); // Second number

        int d = getproduct(b, n1, n2);
        System.out.println(d);
    }

    public static int getproduct(int b, int n1, int n2) {
        int result = 0;
        int power = 1;

        while (n2 > 0) {
            int d2 = n2 % 10;
            n2 = n2 / 10;

            int singleProduct = getprodwithasingledig(b, n1, d2);
            result = getsum(b, result, singleProduct * power);
            power *= 10;
        }
        return result;
    }

    public static int getprodwithasingledig(int b, int n1, int d2) {
        int result = 0;
        int carry = 0;
        int power = 1;

        while (n1 > 0 || carry > 0) {
            int d1 = n1 % 10;
            n1 = n1 / 10;

            int product = d2 * d1 + carry;
            carry = product / b;
            int remainder = product % b;

            result += remainder * power;
            power *= 10;
        }
        return result;
    }

    public static int getsum(int b, int n1, int n2) {
        int result = 0;
        int carry = 0;
        int power = 1;

        while (n1 > 0 || n2 > 0 || carry > 0) {
            int d1 = n1 % 10;
            int d2 = n2 % 10;

            n1 = n1 / 10;
            n2 = n2 / 10;

            int sum = d1 + d2 + carry;
            carry = sum / b;
            int remainder = sum % b;

            result += remainder * power;
            power *= 10;
        }
        return result;
    }
}